package com.company;


import com.google.gson.*;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();

        String metaDataJson = "{\"version\":1,\"id\":31456456465,\"amount\":456456.56,\"amountType\":\"kg\",\"containerType\":\"20\"}";

        ContainerLoadedEvent event = new ContainerLoadedEvent(metaDataJson);

        event.getMetaData();

        System.out.println("It worked");
        System.out.println(gson.toJson(event.getMetaData()));

    }
}
