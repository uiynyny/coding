package com.leetcode.ood.elevator;

import java.util.List;

interface HandleRequestStrategy {
    void handleRequest(ExternalRequest externalRequest, List<Elevator> elevators);
}
