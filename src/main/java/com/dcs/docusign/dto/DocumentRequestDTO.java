package com.dcs.docusign.dto;

public class DocumentRequestDTO {
    private DocumentMetadataDTO metadata;
    private byte[] fileContent;

    public DocumentMetadataDTO getMetadata() {
        return metadata;
    }
    public void setMetadata(DocumentMetadataDTO metadata) {
        this.metadata = metadata;
    }

    public byte[] getFileContent() {return fileContent;}
    public void setFileContent(byte[] fileContent) {this.fileContent = fileContent;}


}
