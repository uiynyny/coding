package com.leetcode.ood.pubsub;

public interface Publisher {
    void publish(Message message,PubSubService pubSubService);
}
