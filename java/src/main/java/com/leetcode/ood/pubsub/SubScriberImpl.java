package com.leetcode.ood.pubsub;

public class SubScriberImpl extends SubScriber {
    @Override
    public void addSubscriber(String topic, PubSubService pubSubService) {
        pubSubService.addSubscriberToTopic(topic,this);
    }

    @Override
    public void removeSubscriber(String topic, PubSubService pubSubService) {
        pubSubService.removeSubscriberFromTopic(topic,this);
    }

    @Override
    public void getMessageForTopic(String topic, PubSubService pubSubService) {
        pubSubService.getMessageForSubscriberOfTopic(topic,this);
    }

    @Override
    public void update(Message m) {
        this.messageList.add(m);
    }

}
