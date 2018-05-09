package com.company;

import com.google.gson.Gson;

import java.util.*;

/**
 * Abstract Base class for all Events
 * resolve and checks metaData versions
 *
 */
public abstract class BaseEvent {

    private static final Gson gson = new Gson();

    private final List<BaseMetaData> metaDataVersions = new ArrayList<>();
    private BaseMetaData metaData;

    /**
     * Class constructor
     * receives metaData as a json string
     *
     * @param data:String
     */
    public BaseEvent(String data){
        this.addMetaDataVersion();
        BaseMetaData metaData = gson.fromJson(data, this.getLastVersion().getClass());
        this.checkVersion(metaData);
        this.setMetaData(metaData);
    }

    /**
     * Checks and upgrades metaData
     *
     * @param data:BaseMetaData
     */
    private void  checkVersion(BaseMetaData data){
        if(!getLastMetaDataVersion().equals(data.getDataVersion())){
            metaDataVersions.subList(data.getDataVersion()-1, this.getLastMetaDataVersion()).forEach(metaData -> {
                metaData.upgrade(data);
                data.setVersion(metaData.getMetaDataVersion());
            });
        }
    }

    /**
     * Get last metadata version number
     *
     * @return Integer
     */
    private Integer getLastMetaDataVersion() {
        return metaDataVersions.size();
    }

    /**
     * Add metadata versions in the correct historical order
     */
    private void addMetaDataVersion(){
        getMetaDataVersions()
                .stream()
                .sorted(Comparator.comparing(BaseMetaData::getMetaDataVersion))
                .forEach(metaData1 -> this.metaDataVersions.add(metaData1.getMetaDataVersion()-1, metaData1));
    }

    /**
     * Get metaDataVersions defined by a child class
     *
     * @return List<BaseMetaData>
     */
    public abstract List<BaseMetaData> getMetaDataVersions();

    /**
     * Get last metaData version of an event
     *
     * @return BaseMetaData
     */
    private BaseMetaData getLastVersion(){
        return this.metaDataVersions.get(this.metaDataVersions.size()-1);
    }


    public BaseMetaData getMetaData() {return metaData;}

    private void setMetaData(BaseMetaData metaData) {this.metaData = metaData;}
}
