package com.lld.eventbus.model;

import com.lld.eventbus.exception.EventNotFoundException;
import com.lld.eventbus.utils.KeyedExecutor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class EventBus {
    private final KeyedExecutor executor;
    private final Map<String, List<Subscription>> topicSubscriberMap;
    private final Map<String, List<Event>> topics;
    private final Map<String, Set<Subscription>> subscribers;
    private final Map<String, Map<String, String>> subscriberIndexes;
    private Map<String, ConcurrentSkipListMap<Long, String>> eventTimestamps;


    public EventBus(int threads, Map<String, Map<String, String>> subscriberIndexes) {
        this.subscriberIndexes = subscriberIndexes;
        this.topicSubscriberMap = new ConcurrentHashMap<>();
        this.topics = new ConcurrentSkipListMap<>();
        this.subscribers = new ConcurrentHashMap<>();
        this.executor = new KeyedExecutor(threads);
    }

    //here I am publishing the event
    public void publish(String topic, Event event){
        executor.submit(topic, () -> topics.get(topic).add(event));
    }

    public void subScribeForPull(String topic, Subscription subscribtion){
        subscribers.get(topic).add(subscribtion);
    }

//    List<Event>
    public  void setIndexEventAfterTimeStamp(String topic, Long timestamp, ){
        subscriberIn.put()
    }

    public Event getEvent(String topic, String eventId) throws EventNotFoundException {
        return topics.get(topic)
                .stream().
                filter(event -> event.getId()
                .equals(eventId))
                .findAny()
                .orElseThrow(() -> new EventNotFoundException());
    }

    // To notify all the subscriber
    private void notify(Topic topic, Event event){
        topicSubscriberMap.get(topic);
    }
}
