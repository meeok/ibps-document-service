package com.kelmorgan.ibpsdocumentservice.initializer;

public interface IBPSDocumentHandler {

    void importDocument(String documentInBase64,String IBPSDocumentName, String tempDirectory, String fileName,String fileType,String wiName);
}
