package com.kelmorgan.ibpsdocumentservice.service.utils;

import ISPack.CPISDocumentTxn;
import ISPack.ISUtil.JPDBRecoverDocData;
import ISPack.ISUtil.JPISException;
import ISPack.ISUtil.JPISIsIndex;
import com.kelmorgan.ibpsdocumentservice.utils.LoadProp;

public class AddDocumentToImageServer implements ValidateDocumentServiceActions {


    private boolean isImageAddedToServer;
    private final String documentPath;
    private final DocumentBeanInfo info;
    private final LoadProp loadProp;

    public AddDocumentToImageServer(String documentPath, DocumentBeanInfo info, LoadProp loadProp) {
        this.documentPath = documentPath;
        this.info = info;
        this.loadProp = loadProp;
        addDocumentToImageServer();
    }

    @Override
    public boolean isDone() {
        return isImageAddedToServer;
    }

    public void addDocumentToImageServer() {
        try {
            JPISIsIndex IsIndex = new JPISIsIndex();
            JPDBRecoverDocData recoveryData = new JPDBRecoverDocData();
            CPISDocumentTxn.AddDocument_MT(null,loadProp.getServerIp(), Short.parseShort(loadProp.getServerWrapperPort()), loadProp.getServerCabinetName(), Short.parseShort(loadProp.getVolumeId()), documentPath,
                    recoveryData, "", IsIndex);
            info.setIsIndex(IsIndex.m_nDocIndex);
            info.setVolumeId(IsIndex.m_sVolumeId);
            info.setDocSize(recoveryData.m_nDocumentSize);
            setImageAddedToServer(true);
        } catch (Exception | JPISException e) {
            setImageAddedToServer(false);
        }
    }

    private void setImageAddedToServer(boolean imageAddedToServer) {
        isImageAddedToServer = imageAddedToServer;
    }
}
