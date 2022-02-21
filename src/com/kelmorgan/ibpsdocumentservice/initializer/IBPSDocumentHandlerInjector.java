package com.kelmorgan.ibpsdocumentservice.initializer;

public interface IBPSDocumentHandlerInjector {
    IBPSDocumentHandler getIBPSDocumentService(String configPath);
}
