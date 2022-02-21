package com.kelmorgan.ibpsdocumentservice.service.utils;

public class DocumentBeanInfo {

    private int isIndex;
    private int volumeId;
    private long docSize;

    public void setIsIndex(int isIndex) {
        this.isIndex = isIndex;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public long getDocSize() {
        return docSize;
    }

    public void setDocSize(long docSize) {
        this.docSize = docSize;
    }

    public String getISVIDocumentIndex() {
        return  isIndex+ "#" + volumeId + "#";
    }
}
