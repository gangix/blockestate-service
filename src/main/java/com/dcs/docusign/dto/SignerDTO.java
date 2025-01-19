package com.dcs.docusign.dto;

public class SignerDTO {
    private String signerName;
    private String email;
    private String recipientId;
    private Role role;

    public SignerDTO(String signerName, String email, String recipientId, Role role) {
        this.signerName = signerName;
        this.email = email;
        this.recipientId = recipientId;
        this.role = role;
    }

    public void setSignerName(String signerName) {this.signerName = signerName;}
    public String getSignerName() {return signerName;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public void setRecipientId(String recipientId) {this.recipientId = recipientId;}
    public String getRecipientId() {return recipientId;}

    public void setRole(Role role) {this.role = role;}
    public Role getRole() {return role;}
}
