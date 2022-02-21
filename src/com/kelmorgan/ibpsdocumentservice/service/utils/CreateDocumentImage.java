package com.kelmorgan.ibpsdocumentservice.service.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.FileOutputStream;

public class CreateDocumentImage implements ValidateDocumentServiceActions {

    private final String documentInBase64;
    private final String documentFullPath;
    private boolean isCreated;

    public CreateDocumentImage(String documentInBase64, String documentFullPath) {
        this.documentInBase64 = documentInBase64;
        this.documentFullPath = documentFullPath;
        createDocument();
    }

    @Override
    public boolean isDone() {
        return isCreated;
    }

    private void setCreated(boolean created) {
        isCreated = created;
    }

    private void createDocument() {
        byte[] documentByteArray;
        FileOutputStream createdDocument;
        try {
            documentByteArray = Base64.decodeBase64(documentInBase64);
            createdDocument = new FileOutputStream(documentFullPath);
            createdDocument.write(documentByteArray);
            setCreated(true);
        } catch (Exception e) {
            setCreated(false);
        }
    }
}
