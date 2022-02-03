package com.leetcode.ood.pubsub;

public class PublisherImpl implements Publisher{
    @Override
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}
