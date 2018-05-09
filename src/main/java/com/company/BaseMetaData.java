package com.company;

/**
 * Abstract Base class for MetaData
 *
 * ATTENTION:
 * ->A new metaData version extends the previos one
 * ->Every metaData version need to override upgrade(MetaData metaData
 * ->New metaData versions need to be registered in it's event
 */
public abstract class BaseMetaData{


    private Integer version;

    /**
     * Get metadata version from event store
     *
     * @return Integer
     */
    public Integer getDataVersion(){ return version;}

    public void setVersion(Integer version){
        this.version = version;
    }

    /**
     * Get metadata version of a child
     *
     * @return Integer
     */
    public Integer getMetaDataVersion(){
        int i;
        Class<?> clazz = this.getClass();
        for(i=0; clazz != BaseMetaData.class; i++){ clazz = clazz.getSuperclass(); }
        return i;
    }

    /**
     * Upgrade given json data
     * ->Overridden by each child
     *
     * @param baseMetaData BaseMetaData
     */
    public abstract void upgrade(BaseMetaData baseMetaData);

    /**
     * Implemented only by first child
     *
     * @return Class<? extends BaseEvent>
     */
    public abstract Class<? extends BaseEvent> getEventClass();
}
