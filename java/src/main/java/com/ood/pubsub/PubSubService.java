package com.ood.pubsub;


import java.util.*;

public class PubSubService {

    private Map<String, Set<SubScriber>> subscriberTopicMap = new HashMap<>();

    private Queue<Message> messageQueue = new LinkedList<>();

    public Queue<Message> getMessageQueue() {
        return messageQueue;
    }

    public void addMessageToQueue(Message message) {
        this.messageQueue.add(message);
    }

    public void addSubscriberToTopic(String topic, SubScriberImpl subScriber) {
        if (!subscriberTopicMap.containsKey(topic)) {
            subscriberTopicMap.put(topic, new HashSet<>());
        }
        Set<SubScriber> subScribers = subscriberTopicMap.get(topic);
        subScribers.add(subScriber);
        subscriberTopicMap.put(topic, subScribers);
    }

    public void removeSubscriberFromTopic(String topic, SubScriberImpl subScriber) {
        if (subscriberTopicMap.containsKey(topic)) {
            Set<SubScriber> subScribers = subscriberTopicMap.get(topic);
            subScribers.remove(subScriber);
        }
    }

    public void getMessageForSubscriberOfTopic(String topic, SubScriber subScriber) {
        if (messageQueue.isEmpty()) System.out.println("Queue is empty");
        else {
            while (!messageQueue.isEmpty()) {
                Message message = messageQueue.poll();
                if (message.getTopic().equalsIgnoreCase(topic) && subscriberTopicMap.containsKey(topic)) {

                    for (SubScriber sub : subscriberTopicMap.get(topic)) {
                        List<Message> messages = sub.getMessageList();
                        messages.add(message);
                        sub.setMessageList(messages);
                    }
                }
            }
        }
    }

    public void broadCast() {
        if (messageQueue.isEmpty()) System.out.println("Queue is Empty");
        else {
            while (!messageQueue.isEmpty()) {
                Message message = messageQueue.poll();
                Set<SubScriber> subScribers = subscriberTopicMap.get(message.getTopic());
                for (SubScriber subScriber : subScribers) {
                    List<Message> messageList = subScriber.getMessageList();
                    messageList.add(message);
                    subScriber.setMessageList(messageList);
                }
            }
        }
    }

    private void notify(SubScriber s, Message m){
        s.update(m);
    }
}
