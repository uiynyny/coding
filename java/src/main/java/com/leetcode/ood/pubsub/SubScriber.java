package com.leetcode.ood.pubsub;

import java.util.List;

public abstract class SubScriber {
    protected List<Message> messageList;

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public abstract void addSubscriber(String topic, PubSubService pubSubService);

    public abstract void removeSubscriber(String topic, PubSubService pubSubService);

    public abstract void getMessageForTopic(String topic, PubSubService pubSubService);

    public abstract void update(Message m);
}
