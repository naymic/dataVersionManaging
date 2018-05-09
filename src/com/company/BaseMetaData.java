package com.company;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;

public abstract class BaseMetaData implements MetaDataInterface{

    private Integer version;

    public Integer getDataVersion(){ return version;}

    public void setVersion(Integer version){
        this.version = version;
    }


}
