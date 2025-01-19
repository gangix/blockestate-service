package com.dcs.docusign.dto;

public enum DocumentStatus {
    InProgress,
    SignedOrCompleted,
    Declined,
    Unknown;

    public static DocumentStatus fromPayload(String event) {
        if(event.contains("completed")) {
            return DocumentStatus.SignedOrCompleted;
        }else if(event.contains("declined")) {
            return Declined;
        } else{
            return Unknown;
        }
    }
}
