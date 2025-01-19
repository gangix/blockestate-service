package com.dcs.docusign.controller;

import com.dcs.docusign.dto.*;
import com.dcs.docusign.service.*;
import com.docusign.esign.client.ApiException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ContentTypeUtils;

import java.io.IOException;
import java.util.List;

@RestController
public class EscrowController {

    private static final Logger log = LoggerFactory.getLogger(EscrowController.class);
    private final EscrowPdfService escrowPdfService;
    private final DocumentService documentService;
    private final EthereumService ethereumService;

    public EscrowController(EscrowPdfServiceImpl escrowPdfService, DocumentService documentService, EthereumService ethereumService) {
        this.escrowPdfService = escrowPdfService;
        this.documentService = documentService;
        this.ethereumService = ethereumService;
    }

    @PostMapping(value = "/escrow")
    public ResponseEntity<Void> generateEscrowAgreement(@RequestBody MultiValueMap<String, String> formParams) {
        try {
            String payerName = formParams.getFirst("payerName");
            String payerEmail = formParams.getFirst("payerEmail");
            String payerEthAddress = formParams.getFirst("payerEthAddress");
            String payeeName = formParams.getFirst("payeeName");
            String payeeEmail = formParams.getFirst("payeeEmail");
            String payeeEthAddress = formParams.getFirst("payeeEthAddress");
            String transactionHash = formParams.getFirst("transactionHash");
            String amount = formParams.getFirst("amount");

            log.info("Request to generate escrow agreement captured.");
            byte[] pdfContent = escrowPdfService.generateEscrowAgreementPdf(payerName, payerEmail, payeeName,
                    payeeEmail, amount);
            DocumentRequestDTO documentRequestDTO = buildDocumentRequestDTO(payerName, payerEmail, payeeName, payeeEmail, amount, payerEthAddress, payeeEthAddress, transactionHash, pdfContent);
            documentService.handleIncomingDocument(documentRequestDTO);

            return ResponseEntity.ok().build();
        } catch (IOException | ApiException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/escrows")
    public ResponseEntity<List<DocumentDetailsDTO>> getAllAgreements() {
        return ResponseEntity.ok().body(documentService.getAllAgreements());
    }

    private @NotNull DocumentRequestDTO buildDocumentRequestDTO(String payerName, String payerEmail, String payeeName, String payeeEmail, String amount, String payerEthAddress, String payeeEthAddress, String transactionHash, byte[] pdfContent) {
        DocumentRequestDTO documentRequestDTO = new DocumentRequestDTO();
        documentRequestDTO.setFileContent(pdfContent);
        DocumentMetadataDTO documentMetadataDTO  = new DocumentMetadataDTO();
        documentMetadataDTO.setTransactionHash(transactionHash);
        documentMetadataDTO.setDocumentName("Escrow Agreement.pdf");
        var payer = new SignerDTO(payerName, payerEmail, "1", Role.Payer);
        var payee = new SignerDTO(payeeName, payeeEmail, "2", Role.Payee);
        documentMetadataDTO.setSignerList(List.of(payee, payer));
        documentMetadataDTO.setDocumentId("1");
        documentMetadataDTO.setFileExtension("pdf");
        documentMetadataDTO.setAmount(amount);
        documentMetadataDTO.setPayeeEthAddress(payeeEthAddress);
        documentMetadataDTO.setPayerEthAddress(payerEthAddress);
        documentRequestDTO.setMetadata(documentMetadataDTO);

        return documentRequestDTO;
    }
}
