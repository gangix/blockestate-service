package com.dcs.docusign.entity;

import com.dcs.docusign.dto.DocumentStatus;
import com.dcs.docusign.dto.TransactionStatus;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "documents")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentId;

    @Column
    private String envelopeId;

    @Column
    private String payerEmailAddress;

    @Column
    private String payeeEmailAddress;

    @Column
    private String payeeEthAddress;

    @Column
    private String payerEthAddress;

    @Column(nullable = false)
    private String documentName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionResult;

    @Column
    private String amount;

    @Column
    private String declinedReason;

    @Column
    private String transactionHash;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEnvelopeId() {
        return envelopeId;
    }
    public void setEnvelopeId(String envelopeId) {
        this.envelopeId = envelopeId;
    }

    public DocumentStatus getStatus() {return status;}
    public void setStatus(DocumentStatus status) {this.status = status;}

    public String getDocumentName() {
        return documentName;
    }
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDeclinedReason() {
        return declinedReason;
    }
    public void setDeclinedReason(String reason) {
        this.declinedReason = reason;
    }

    public String getPayerEmailAddress() {return payerEmailAddress;}
    public void setPayerEmailAddress(String payerEmailAddress) {this.payerEmailAddress = payerEmailAddress;}

    public String getPayeeEmailAddress() {return payeeEmailAddress;}
    public void setPayeeEmailAddress(String payeeEmailAddress) {this.payeeEmailAddress = payeeEmailAddress;}

    public String getPayerEthAddress() {return payerEthAddress;}
    public void setPayerEthAddress(String payerEthAddress) {this.payerEthAddress = payerEthAddress;}

    public String getPayeeEthAddress() {return payeeEthAddress;}
    public void setPayeeEthAddress(String payeeEthAddress) {this.payeeEthAddress = payeeEthAddress;}

    public String getAmount() {return amount;}
    public void setAmount(String amount) {this.amount = amount;}

    public TransactionStatus getTransactionResult() {return transactionResult;}
    public void setTransactionResult(TransactionStatus transactionResult) {this.transactionResult = transactionResult;}

    public String getTransactionHash() {return transactionHash;}
    public void setTransactionHash(String transactionHash) {this.transactionHash = transactionHash;}
}
