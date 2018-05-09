package com.company;

/**
 * Abstract Base class for MetaData
 *
 * ATENTION:
 * -A new metaData version extends the previos one
 * -Every metaData version need to implement upgrade(MetaData metaData
 * -New metaData versions need to be registered in it's event
 */
public abstract class BaseMetaData{

    private Integer version;

    public Integer getDataVersion(){ return version;}

    public void setVersion(Integer version){
        this.version = version;
    }

    public Integer getMetaDataVersion(){
        int i;
        Class<?> clazz = this.getClass();
        for(i=0; clazz != BaseMetaData.class; i++){ clazz = clazz.getSuperclass(); }
        return i;
    }

    public abstract void upgrade(BaseMetaData baseMetaData);

}
