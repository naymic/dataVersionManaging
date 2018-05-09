package com.company.ContainerLoadedEvent;

import com.company.BaseMetaData;

public class ContainerLoadedMetadata_v3 extends ContainerLoadedMetadata_v2 {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        ContainerLoadedMetadata_v3 data = (ContainerLoadedMetadata_v3) baseMetaData;
        data.setLocation("Basel, SBB");
    }
}
