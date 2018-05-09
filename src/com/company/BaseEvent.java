package com.company;

import com.google.gson.Gson;

import java.util.*;

public abstract class BaseEvent {

    private static Gson gson = new Gson();
    List<BaseMetaData> metaDataVersions = new ArrayList<>();
    BaseMetaData metaData;

    public BaseEvent(String data){
        this.addMetaDataVersion();
        BaseMetaData metaData = gson.fromJson(data, this.getLastVersion().getClass());
        this.checkVersion(metaData);
        this.metaData = metaData;
    }

    private void  checkVersion(BaseMetaData data){
        if(!getLastMetaDataVersion().equals(data.getDataVersion())){
            metaDataVersions.forEach(metaData -> metaData.upgrade(data));
        }
    }




    private Integer getLastMetaDataVersion() {
        return metaDataVersions.size();
    }

    private void addMetaDataVersion(){
        getMetaDataVersions()
                .stream()
                .sorted((o1, o2) -> o1.getMetaDataVersion().compareTo(o2.getMetaDataVersion()))
                .forEach(metaData1 -> {
                    this.metaDataVersions.add(metaData1.getMetaDataVersion()-1, metaData1);
                });
    }

    public abstract List<BaseMetaData> getMetaDataVersions();

    public BaseMetaData getLastVersion(){
        return this.metaDataVersions.get(this.metaDataVersions.size()-1);
    }


    public BaseMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(BaseMetaData metaData) {
        this.metaData = metaData;
    }
}
