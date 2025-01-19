package com.dcs.docusign.service;

import com.dcs.docusign.dto.DocumentRequestDTO;
import com.dcs.docusign.dto.Role;
import com.dcs.docusign.dto.SignerDTO;
import com.docusign.esign.api.EnvelopesApi;
import com.docusign.esign.client.ApiClient;
import com.docusign.esign.client.ApiException;
import com.docusign.esign.model.Number;
import com.docusign.esign.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class DocuSignServiceImpl implements DocuSignService{

    private final ApiClient apiClient;
    private final String accountId;
    public static final String EMAIL_SUBJECT = "Please sign this document";

    public DocuSignServiceImpl(ApiClient apiClient, String accountId) {
        this.apiClient = apiClient;
        this.accountId = accountId;
    }

    @Override
    public String sendDocumentForSignature(DocumentRequestDTO documentRequestDTO) throws ApiException {
        EnvelopesApi envelopesApi = new EnvelopesApi(apiClient);

        Document document = new Document();
        document.setDocumentBase64(Base64.getEncoder().encodeToString(documentRequestDTO.getFileContent()));
        document.setName(documentRequestDTO.getMetadata().getDocumentName());
        document.setFileExtension(documentRequestDTO.getMetadata().getFileExtension());
        document.setDocumentId(documentRequestDTO.getMetadata().getDocumentId());

        SignHere signHerePayer = new SignHere();
        signHerePayer.setDocumentId(documentRequestDTO.getMetadata().getDocumentId());
        signHerePayer.setPageNumber("1");
        signHerePayer.setXPosition("191");
        signHerePayer.setYPosition("500");
        Tabs tabsPayer = new Tabs();
        tabsPayer.setSignHereTabs(List.of(signHerePayer));

        SignHere signHerePayee = new SignHere();
        signHerePayee.setDocumentId(documentRequestDTO.getMetadata().getDocumentId());
        signHerePayee.setPageNumber("1");
        signHerePayee.setXPosition("191");
        signHerePayee.setYPosition("540");
        Tabs tabsPayee = new Tabs();
        tabsPayee.setSignHereTabs(List.of(signHerePayee));


        List<Signer> signers = new ArrayList<>();
        for(var signerDto: documentRequestDTO.getMetadata().getSignerList()) {
            Signer signer = new Signer();
            signer.setEmail(signerDto.getEmail());
            signer.setName(signerDto.getSignerName());
            signer.recipientId(signerDto.getRecipientId());
            signer.setRoleName(signerDto.getRole().name());
            if(signerDto.getRole() == Role.Payer){
                signer.setTabs(tabsPayer);
            } else{
                signer.setTabs(tabsPayee);
            }
            signers.add(signer);
        }

        Recipients recipients = new Recipients();
        recipients.setSigners(signers);

        EnvelopeDefinition envelopeDefinition = new EnvelopeDefinition();
        envelopeDefinition.setEmailSubject(EMAIL_SUBJECT);
        envelopeDefinition.setDocuments(List.of(document));
        envelopeDefinition.setRecipients(recipients);
        envelopeDefinition.setStatus("sent");


        EnvelopeSummary result = envelopesApi.createEnvelope(accountId, envelopeDefinition);

        return result.getEnvelopeId();
    }

    private @NotNull Tabs getTabs(SignerDTO signerDto) {
        Tabs tabs = new Tabs();
        if(signerDto.getRole() == Role.Payer) {
            Text tab1 = new Text();
            tab1.setTabLabel("PAYER_NAME");
            tab1.setValue(signerDto.getSignerName());
            Text tab2 = new Text();
            tab2.setName("PAYER_ETH_ADDRESS");
            tab2.setValue("0x2341234124434343124132431243141224134321");
            Number numberTab = new Number();
            numberTab.setTabLabel("AMOUNT_ETH");
            numberTab.setValue("3.67");

            tabs.setTextTabs(List.of(tab1, tab2));
            tabs.setNumberTabs(List.of(numberTab));
        } else if(signerDto.getRole() == Role.Payee) {
            Text tab1 = new Text();
            tab1.setTabLabel("PAYEE_NAME");
            tab1.setValue(signerDto.getSignerName());
            Text tab2 = new Text();
            tab2.setTabLabel("PAYEE_ETH_ADDRESS");
            tab2.setValue("0x2341234124434343124132431243141232434332");
            tabs.setTextTabs(List.of(tab1, tab2));
        }
        return tabs;
    }
}
