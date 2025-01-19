package com.dcs.docusign.service;

import com.dcs.docusign.dto.*;
import com.dcs.docusign.entity.Document;
import com.dcs.docusign.repository.DocumentRepository;
import com.docusign.esign.client.ApiException;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    private static final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);
    private final DocumentRepository documentRepository;
    private final DocuSignService docuSignService;
    private final EthereumService ethereumService;


    public DocumentServiceImpl(DocumentRepository documentRepository, DocuSignService docuSignService, EthereumService ethereumService) {
        this.documentRepository = documentRepository;
        this.docuSignService = docuSignService;
        this.ethereumService = ethereumService;
    }

    @Transactional
    @Override
    public void handleIncomingDocument(DocumentRequestDTO documentRequestDTO) throws ApiException {
        var envelopeId = docuSignService.sendDocumentForSignature(documentRequestDTO);
        log.info("Envelope ID: {}", envelopeId);
        DocumentMetadataDTO metadata = documentRequestDTO.getMetadata();
        Document document = new Document();
        document.setDocumentId(metadata.getDocumentId());
        document.setDocumentName(metadata.getDocumentName());
        document.setEnvelopeId(envelopeId);
        document.setAmount(metadata.getAmount());
        document.setStatus(DocumentStatus.InProgress);
        document.setTransactionHash(metadata.getTransactionHash());
        document.setPayerEmailAddress(metadata.getSignerList().stream().filter(signerDTO -> signerDTO.getRecipientId().equals("1")).findFirst().get().getEmail());
        document.setPayeeEmailAddress(metadata.getSignerList().stream().filter(signerDTO -> signerDTO.getRecipientId().equals("2")).findFirst().get().getEmail());
        document.setPayeeEthAddress(metadata.getPayeeEthAddress());
        document.setPayerEthAddress(metadata.getPayerEthAddress());
        document.setTransactionResult(TransactionStatus.InProgress);
        documentRepository.save(document);
    }

    @Transactional
    @Override
    public void updateSigningStatus(WebhookPayload webhookPayload) {
        var optionalDocument = documentRepository.findByEnvelopeId(webhookPayload.getData().getEnvelopeId());
        optionalDocument.ifPresentOrElse(document -> {
            log.info("Webhook captured, updating signing status for document ID: {}", document.getDocumentId());
            document.setStatus(DocumentStatus.fromPayload(webhookPayload.getEvent()));
            document.setDeclinedReason(webhookPayload.getDeclinedReason());
            if(document.getStatus() == DocumentStatus.SignedOrCompleted) {
                log.info("Signature is signed or completed, Transaction is being executed");
                ethereumService.completeTransaction(document.getTransactionHash());
                document.setTransactionResult(TransactionStatus.Completed);
            } else {
                log.info("Signature is declined, Transaction is being cancelled");
                ethereumService.cancelTransaction(document.getDocumentId());
                document.setTransactionResult(TransactionStatus.Canceled);
            }
            documentRepository.save(document);
            },
        () -> log.error("Could not find document with envelopeId: {}", webhookPayload.getData().getEnvelopeId()));
    }

    @Override
    public List<DocumentDetailsDTO> getAllAgreements() {
        var list = documentRepository.findAll().stream().map(DocumentDetailsDTO::fromDocument).toList();
        list.forEach(dto -> log.info("Document: {}", dto.toString()));

        return list;
    }
}
