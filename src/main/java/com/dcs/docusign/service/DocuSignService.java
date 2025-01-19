package com.dcs.docusign.service;

import com.dcs.docusign.dto.DocumentRequestDTO;
import com.docusign.esign.client.ApiException;

public interface DocuSignService {
    String sendDocumentForSignature(DocumentRequestDTO documentRequestDTO) throws ApiException;
}
