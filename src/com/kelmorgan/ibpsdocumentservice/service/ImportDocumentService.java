package com.kelmorgan.ibpsdocumentservice.service;

import com.kelmorgan.ibpsdocumentservice.controllers.IBPSDocumentApis;
import com.kelmorgan.ibpsdocumentservice.initializer.IBPSDocumentHandler;
import com.kelmorgan.ibpsdocumentservice.service.utils.AddDocumentToImageServer;
import com.kelmorgan.ibpsdocumentservice.service.utils.CreateDocumentDirectory;
import com.kelmorgan.ibpsdocumentservice.service.utils.CreateDocumentImage;
import com.kelmorgan.ibpsdocumentservice.service.utils.DocumentBeanInfo;
import com.kelmorgan.ibpsdocumentservice.utils.IBPSServiceApi;
import com.kelmorgan.ibpsdocumentservice.utils.LoadProp;

import java.io.File;

public class ImportDocumentService implements IBPSDocumentHandler {

    private final LoadProp loadProp;
    private final IBPSServiceApi serviceApi;
    private final IBPSDocumentApis documentApis;

    public ImportDocumentService(String configPath) {
        loadProp = new LoadProp(configPath);
        serviceApi = new IBPSServiceApi(configPath);
        documentApis = new IBPSDocumentApis(serviceApi);
    }


    @Override
    public void importDocument(String documentInBase64, String IBPSDocumentName, String tempDirectory, String fileName, String fileType, String wiName) {
        CreateDocumentDirectory createDocumentDirectory = new CreateDocumentDirectory(tempDirectory);
        if (createDocumentDirectory.isDone()) {
            String documentFullPath = tempDirectory + File.separator + fileName;
            CreateDocumentImage createDocumentImage = new CreateDocumentImage(documentInBase64, documentFullPath);
            if (createDocumentImage.isDone()) {
                DocumentBeanInfo info = new DocumentBeanInfo();
                AddDocumentToImageServer documentToImageServer = new AddDocumentToImageServer(documentFullPath, info, loadProp);
                if (documentToImageServer.isDone()) {
                    String folderIndex = documentApis.getFolderIndex(wiName);
                    documentApis.addDocumentToWorkItem(folderIndex, String.valueOf(info.getDocSize()), "1", IBPSDocumentName, info.getISVIDocumentIndex(), fileType, "I");
                    documentApis.getDocumentList(wiName);
                }
            }

        }

    }


}
