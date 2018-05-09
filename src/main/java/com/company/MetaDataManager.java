package com.company;

import com.company.utils.ReflectionUtil;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

/**
 * Collect all metadata in the project and map them by event
 */
public class MetaDataManager {

    /** Singleton*/
    private static MetaDataManager instance = null;
    private MetaDataManager(){
        setUpEventMetaDataMapping();
    }
    public static MetaDataManager getInstance(){
        if(instance == null){
            instance = new MetaDataManager();
        }
        return instance;
    }

    private Map<Class<?>, List<BaseMetaData>> eventMetaDataMap  = new Hashtable<>();

    /**
     * Find, sort and group metadata by events
     */
    private void setUpEventMetaDataMapping(){
        setEventMetaDataMap(
                ReflectionUtil.getMetaDataImplementations()
                .parallelStream()
                .map(ReflectionUtil::createMetaDataInstance)
                .sorted(comparingInt(BaseMetaData::getMetaDataVersion))
                .collect(Collectors.groupingBy(BaseMetaData::getEventClass, Collectors.toList()))
        );
    }

    /**
     * Get metadata for a event
     *
     * @param eventClass:Class<? extends BaseEvent>
     * @return List<BaseMetaData>
     */
    public List<BaseMetaData> getEventMetaDataVersions(Class<? extends BaseEvent> eventClass){
        return this.getEventMetaDataMap().get(eventClass);
    }

    private Map<Class<?>, List<BaseMetaData>> getEventMetaDataMap() {
        return eventMetaDataMap;
    }

    private void setEventMetaDataMap(Map<Class<?>, List<BaseMetaData>> eventMetaDataMap) {
        this.eventMetaDataMap = eventMetaDataMap;
    }
}
