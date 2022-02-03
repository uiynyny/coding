package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TimeNeededtoInformAllEmployees {
    private static final Logger logger = Logger.getLogger(TimeNeededtoInformAllEmployees.class.getName());

    public static void main(String[] args) {
        TimeNeededtoInformAllEmployees obj = new TimeNeededtoInformAllEmployees();
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] time = {0, 0, 1, 0, 0, 0};
        logger.info("" + obj.numOfMinutes(6, 2, manager, time));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.putIfAbsent(manager[i], new ArrayList<>());
            g.get(manager[i]).add(i);
        }
        return dfs(g, headID, informTime);
    }

    public int dfs(Map<Integer, List<Integer>> g, int u, int[] time) {
        int max = 0;
        if (!g.containsKey(u)) return max;
        for (int v : g.get(u)) {
            max = Math.max(max, dfs(g, v, time));
        }
        return max + time[u];
    }
}
