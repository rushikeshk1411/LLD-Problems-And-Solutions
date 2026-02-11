package com.lld.eventbus.model;

import com.lld.eventbus.utils.SubscriptionType;

import java.util.function.Function;

public class Subscription {
    private String id;
    private String topicId;
    private String subscriberId;
    private SubscriptionType subscriptionType;
    private Function<Event, Boolean> preCondition;

    public Subscription(final String id, final String topicId, final String subscriberId, final SubscriptionType subscriptionType, final Function<Event, Boolean> preCondition){
        this.id = id;
        this.topicId = topicId;
        this.subscriberId = subscriberId;
        this.subscriptionType = subscriptionType;
        this.preCondition = preCondition;
    }


}
