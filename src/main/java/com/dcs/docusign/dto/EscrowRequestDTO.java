package com.dcs.docusign.dto;

public class EscrowRequestDTO {
    private String payerName;
    private String payeeName;
    private String payerEmail;
    private String payeeEmail;
    private String payerEthAddress;
    private String payeeEthAddress;
    private String transactionHash;
    private String amount;

    public String getPayerName() {
        return payerName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public String getPayeeEmail() {
        return payeeEmail;
    }

    public String getPayerEthAddress() {
        return payerEthAddress;
    }

    public String getPayeeEthAddress() {
        return payeeEthAddress;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public String getAmount() {
        return amount;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }

    public void setPayerEthAddress(String payerEthAddress) {
        this.payerEthAddress = payerEthAddress;
    }

    public void setPayeeEthAddress(String payeeEthAddress) {
        this.payeeEthAddress = payeeEthAddress;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
