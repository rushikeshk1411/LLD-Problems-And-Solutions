package com.lld.eventbus;

import java.util.List;
import java.util.Map;

public class EventBus {
    private final Map<Topic, List<Subscriber>> topicSubscriberMap;
    private final Map<Topic, List<Event>> topics;

    public EventBus(Map<Topic, List<Subscriber>> topicSubscriberMap, Map<Topic, List<Event>> topics) {
        this.topicSubscriberMap = topicSubscriberMap;
        this.topics = topics;
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
