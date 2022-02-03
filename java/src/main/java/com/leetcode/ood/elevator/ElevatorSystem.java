package com.leetcode.ood.elevator;

import java.util.List;

public class ElevatorSystem{
    private List<Elevator> elevatorList;
    private HandleRequestStrategy handleRequestStrategy;

    public void setHandleRequestStrategy(HandleRequestStrategy handleRequestStrategy) {
        this.handleRequestStrategy = handleRequestStrategy;
    }

    public void handleRequest(ExternalRequest externalRequest) {

    }
}