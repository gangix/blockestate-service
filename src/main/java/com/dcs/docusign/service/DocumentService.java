package com.dcs.docusign.service;

import com.dcs.docusign.dto.DocumentDetailsDTO;
import com.dcs.docusign.dto.DocumentRequestDTO;
import com.dcs.docusign.dto.WebhookPayload;
import com.docusign.esign.client.ApiException;

import java.util.List;

public interface DocumentService {
    void handleIncomingDocument(DocumentRequestDTO documentRequestDTO) throws ApiException;
    void updateSigningStatus(WebhookPayload webhookPayload);
    List<DocumentDetailsDTO> getAllAgreements();

}
