package com.ood.pubsub;

public interface Publisher {
    void publish(Message message,PubSubService pubSubService);
}
