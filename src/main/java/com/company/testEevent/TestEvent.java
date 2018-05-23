package com.company.testEevent;

import com.company.BaseEvent;


public class TestEvent extends BaseEvent {

    public TestEvent(String data){
        super(data);
    }

    /**
     * Link between a event and its MetaData is defined by first MetaData Class of a certain event
     * Method -> getEventClass()
     */

}
