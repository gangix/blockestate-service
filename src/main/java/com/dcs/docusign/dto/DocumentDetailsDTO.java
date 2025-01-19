package com.dcs.docusign.dto;

import com.dcs.docusign.entity.Document;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DocumentDetailsDTO {
    private String envelopeId;
    private String documentName;
    private DocumentStatus status;
    private String declinedReason;
    private String payerEmailAddress;
    private String payeeEmailAddress;
    private String amount;
    private TransactionStatus transactionStatus;

    public String getDocumentName() {return documentName;}
    public void setDocumentName(String documentName) {this.documentName = documentName;}

    public DocumentStatus getStatus() {return status;}
    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public String getDeclinedReason() {
        return declinedReason;
    }
    public void setDeclinedReason(String declinedReason) {
        this.declinedReason = declinedReason;
    }

    public String getEnvelopeId() {return envelopeId;}
    public void setEnvelopeId(String envelopeId) {this.envelopeId = envelopeId;}

    public String getPayerEmailAddress() {return payerEmailAddress;}
    public void setPayerEmailAddress(String payerEmailAddress) {this.payerEmailAddress = payerEmailAddress;}

    public String getPayeeEmailAddress() {return payeeEmailAddress;}
    public void setPayeeEmailAddress(String payeeEmailAddress) {this.payeeEmailAddress = payeeEmailAddress;}

    public String getAmount() {return amount;}
    public void setAmount(String amount) {this.amount = amount;}

    public TransactionStatus getTransactionStatus() {return transactionStatus;}
    public void setTransactionStatus(TransactionStatus transactionStatus) {this.transactionStatus = transactionStatus;}

    public static DocumentDetailsDTO fromDocument(Document document) {
        DocumentDetailsDTO documentDetailsDTO = new DocumentDetailsDTO();
        documentDetailsDTO.setEnvelopeId(document.getEnvelopeId());
        documentDetailsDTO.setDocumentName(document.getDocumentName());
        documentDetailsDTO.setStatus(document.getStatus());
        documentDetailsDTO.setDeclinedReason(document.getDeclinedReason());
        documentDetailsDTO.setPayerEmailAddress(document.getPayerEmailAddress());
        documentDetailsDTO.setPayeeEmailAddress(document.getPayeeEmailAddress());
        documentDetailsDTO.setAmount(document.getAmount());
        documentDetailsDTO.setTransactionStatus(document.getTransactionResult());
        return documentDetailsDTO;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
