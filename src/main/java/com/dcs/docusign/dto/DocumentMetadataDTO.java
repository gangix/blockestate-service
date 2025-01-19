package com.dcs.docusign.dto;

import java.util.List;

public class DocumentMetadataDTO {
    private String documentId;
    private String documentName;
    private String fileExtension;
    private String amount;
    private String payerEthAddress;
    private String payeeEthAddress;
    private String transactionHash;
    private List<SignerDTO> signerList ;

    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public List<SignerDTO> getSignerList() {
        return signerList;
    }
    public void setSignerList(List<SignerDTO> signerList) {
        this.signerList = signerList;
    }

    public String getDocumentName() {
        return documentName;
    }
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getFileExtension() {return fileExtension;}
    public void setFileExtension(String fileExtension) {this.fileExtension = fileExtension;}

    public String getAmount() {return amount;}
    public void setAmount(String amount) {this.amount = amount;}

    public String getPayerEthAddress() {return payerEthAddress;}
    public void setPayerEthAddress(String payerEthAddress) {this.payerEthAddress = payerEthAddress;}

    public String getPayeeEthAddress() {return payeeEthAddress;}
    public void setPayeeEthAddress(String payeeEthAddress) {this.payeeEthAddress = payeeEthAddress;}

    public String getTransactionHash() {return transactionHash;}
    public void setTransactionHash(String transactionHash) {this.transactionHash = transactionHash;}
}
