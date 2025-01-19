package com.dcs.docusign;

import com.dcs.docusign.dto.DocumentMetadataDTO;
import com.dcs.docusign.dto.DocumentRequestDTO;
import com.dcs.docusign.dto.Role;
import com.dcs.docusign.dto.SignerDTO;
import com.dcs.docusign.service.DocuSignServiceImpl;
import com.dcs.docusign.service.EscrowPdfService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class DocuSignServiceTest {
    @Autowired
    private DocuSignServiceImpl docuSignService;

    @Autowired
    private EscrowPdfService escrowPdfService;


    @Test
    public void testSign() throws Exception {
        String payerName = "olcay", payeeName = "Mahmut", payerEmail = "olcay.bilir@gmail.com", payeeEmail = "bilir.olcay@gmail.com";
        var pdfContent = escrowPdfService.generateEscrowAgreementPdf(payerName, payerEmail,
                payeeName, payeeEmail, "2");

        DocumentRequestDTO documentRequestDTO = new DocumentRequestDTO();
        documentRequestDTO.setFileContent(pdfContent);

        DocumentMetadataDTO documentMetadataDTO  = new DocumentMetadataDTO();
        documentMetadataDTO.setDocumentName("Escrow Agreement.pdf");
        var payer = new SignerDTO(payerName, payerEmail, "1", Role.Payer);
        var payee = new SignerDTO(payeeName, payeeEmail, "2", Role.Payee);
        documentMetadataDTO.setSignerList(List.of(payee, payer));
        documentMetadataDTO.setDocumentId("1");
        documentMetadataDTO.setFileExtension("pdf");
        documentRequestDTO.setMetadata(documentMetadataDTO);

        docuSignService.sendDocumentForSignature(documentRequestDTO);
    }

    public InputStream getResource(String path) throws IOException {
        var resourceLoader = new DefaultResourceLoader();
        var resource = resourceLoader.getResource(path);
        return resource.getInputStream();
    }
}
