package com.company.ContainerLoadedEvent;

import com.company.BaseEvent;
import com.company.BaseMetaData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ContainerLoadedEvent extends BaseEvent {

    public ContainerLoadedEvent(String data){
        super(data);
    }

    private Date created;
    private Date stored;
    private ContainerLoadedMetadata_v3 data;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getStored() {
        return stored;
    }

    public void setStored(Date stored) {
        this.stored = stored;
    }

    public Object getData() {
        return data;
    }

}