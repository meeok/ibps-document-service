package com.kelmorgan.ibpsdocumentservice.initializer;

public interface IBPSDocumentHandler {

    void importDocument(String documentInBase64, String documentName, String fileType);
}
