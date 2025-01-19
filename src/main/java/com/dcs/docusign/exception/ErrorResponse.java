package com.dcs.docusign.exception;

public class ErrorResponse {

    private int status;
    private String message;
    private String details;

    public ErrorResponse(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
    public int getStatus() {return status;}
    public String getMessage() {return message;}
    public String getDetails() {return details;}
}