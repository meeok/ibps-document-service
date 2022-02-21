package com.kelmorgan.ibpsdocumentservice.controllers;

import com.kelmorgan.ibpsdocumentservice.utils.IBPSServiceApi;
import com.kelmorgan.ibpsdocumentservice.utils.Query;
import com.kelmorgan.ibpservices.initializer.IBPSServiceHandler;

import java.util.Map;
import java.util.Set;

public class IBPSDocumentApis {
    private final IBPSServiceHandler serviceHandler;

    public IBPSDocumentApis(IBPSServiceApi serviceApi) {
        this.serviceHandler = serviceApi.initializedService();
    }

    public String getFolderIndex(String wiName) {
        String query = Query.getFolderIndex(wiName);
        Set<Map<String, String>> queryOutput = serviceHandler.getRecords(query);

        String folderIndexColumnName = "FolderIndex";
        for (Map<String, String> result : queryOutput)
            return result.get(folderIndexColumnName.toUpperCase());

        return null;
    }

    public void addDocumentToWorkItem(String folderIndex, String documentSize, String pageCount, String uploadType, String ISIndex, String appName, String docType) {
        serviceHandler.addDocument(folderIndex, documentSize, pageCount, uploadType, ISIndex, appName, docType);
    }

    public void getDocumentList(String wiName){
        serviceHandler.getDocumentList(wiName,"5");
    }
}
