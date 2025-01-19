package com.dcs.docusign.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EscrowPdfServiceImpl implements EscrowPdfService {

    @Override
    public byte[] generateEscrowAgreementPdf(String payerName, String payerAddress, String payeeName, 
                                              String payeeAddress, String amount) throws IOException {
        File file = getResourceFile("classpath:docs/salesContractE.pdf");
        PDDocument document = PDDocument.load(file);

        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        if (acroForm == null) {
            throw new IllegalArgumentException("PDF template does not contain any form fields.");
        }

        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("payerName", payerName);
        placeholders.put("payeeName", payeeName);
        placeholders.put("payeeEthAddress", payeeAddress);
        placeholders.put("payerEthAddress", payerAddress);
        placeholders.put("amountEth", amount);
        placeholders.put("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            PDField field = acroForm.getField(entry.getKey());
            if (field != null) {
                field.setValue(entry.getValue());
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);

        document.close();

        return byteArrayOutputStream.toByteArray();
    }


    public File getResourceFile(String path) throws IOException {
        var resourceLoader = new DefaultResourceLoader();
        var resource = resourceLoader.getResource(path);
        return resource.getFile();
    }
}
