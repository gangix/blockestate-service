package com.dcs.docusign.service;

import java.io.IOException;

public interface EscrowPdfService {
    byte[] generateEscrowAgreementPdf(String payerName, String payerAddress, String payeeName,
                                      String payeeAddress, String amount) throws IOException;
}
