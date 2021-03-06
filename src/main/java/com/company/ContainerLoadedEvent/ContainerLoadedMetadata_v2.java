package com.company.ContainerLoadedEvent;

import com.company.BaseMetaData;

import java.util.Date;

public class ContainerLoadedMetadata_v2 extends ContainerLoadedMetadata_v1 {

    private Date loadingCompleteDate;

    public Date getLoadingCompleteDate() {
        return loadingCompleteDate;
    }

    public void setLoadingCompleteDate(Date loadingCompleteDate) {
        this.loadingCompleteDate = loadingCompleteDate;
    }

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        ContainerLoadedMetadata_v2 baseMetaData1 = (ContainerLoadedMetadata_v2) baseMetaData;
        baseMetaData1.setLoadingCompleteDate(new Date());
        baseMetaData = baseMetaData1;
    }


}
