package com.company;

public interface MetaDataInterface {

    public Integer getMetaDataVersion();

    public void upgrade(BaseMetaData baseMetaData);
}
