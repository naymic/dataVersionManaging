package com.company.utils;


import com.company.BaseMetaData;
import org.reflections.Reflections;


import java.util.Set;

public class ReflectionUtil {

    public static Set<Class<? extends BaseMetaData>> getMetaDataImplementations(){
        Reflections reflections = new Reflections("com.company");
        return reflections.getSubTypesOf(BaseMetaData.class);
    }

    public static BaseMetaData createMetaDataInstance(Class clazz){

        try {
            return (BaseMetaData) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
