package com.lld.eventbus;

public class Topic {
    private String name;
    private String topicId;

    public String getName() {
        return name;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
