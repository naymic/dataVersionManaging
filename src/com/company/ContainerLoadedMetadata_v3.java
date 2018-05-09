package com.company;

public class ContainerLoadedMetadata_v3 extends ContainerLoadedMetadata_v2 implements MetaDataInterface {

    private String location;

    @Override
    public Integer getMetaDataVersion() {
        return 3;
    }

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        ContainerLoadedMetadata_v3 data = (ContainerLoadedMetadata_v3) baseMetaData;
        data.setLocation("Basel, SBB");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
