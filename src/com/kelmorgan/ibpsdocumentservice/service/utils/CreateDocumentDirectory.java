package com.kelmorgan.ibpsdocumentservice.service.utils;

import java.io.File;

public class CreateDocumentDirectory implements ValidateDocumentServiceActions {

    private boolean isCreated;

    private final String documentDirectory;
    private String documentFullPath;

    public CreateDocumentDirectory(String documentDirectory) {
        this.documentDirectory = documentDirectory;
        createDirectory();
    }

    @Override
    public boolean isDone() {
        return isCreated;
    }

    private void setCreated(boolean created) {
        isCreated = created;
    }

    private void createDirectory() {
        File directory;
        try {
            directory = new File(documentDirectory);
            if (directory.exists() && directory.isDirectory()) setCreated(true);
            else setCreated(directory.mkdir());
        } catch (Exception e) {
            setCreated(false);
        }
    }
}
