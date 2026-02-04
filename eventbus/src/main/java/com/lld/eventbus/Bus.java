package com.lld.eventbus;

import java.util.List;
import java.util.Map;

public class Bus {
    private final Map<Topic, List<Subscriber>> topicSubscriberMap;

    public Bus(Map<Topic, List<Subscriber>> topicSubscriberMap){
        this.topicSubscriberMap = topicSubscriberMap;
    }

    //here I am publishing the event
    public String publish(Topic topic, Event event){

        notify(topic, event);

        return "";
    }

    // To notify all the subscriber
    private void notify(Topic topic, Event event){
        topicSubscriberMap.get(topic);

    }
}
