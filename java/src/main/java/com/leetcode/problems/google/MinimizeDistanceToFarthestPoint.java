package com.leetcode.problems.google;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimizeDistanceToFarthestPoint {
    public int pickBlock(Set<String> amentities, List<Set<String>> blocks) {
        int block = 0;
        int minLen = Integer.MAX_VALUE;
        Map<String, Integer> window = new HashMap<>();
        for (int lo = 0, hi = 0; hi < blocks.size(); hi++) {
            blocks.get(hi).forEach(a -> {
                if (amentities.contains(a)) {
                    window.put(a, window.getOrDefault(a, 0) + 1);
                }
            });
            while (window.size() == amentities.size()) {
                // current window fits all points
                int len = hi - lo;
                if (len < minLen) {
                    minLen = len;
                    block = (lo + hi) / 2;
                }
                blocks.get(lo).forEach(a -> {
                    if (amentities.contains(a)) {
                        window.put(a, window.get(a) - 1);
                        if (window.get(a) == 0)
                            window.remove(a);
                    }
                });
                lo++;
            }
        }
        return block;
    }

    public static void main(String[] args) {
        MinimizeDistanceToFarthestPoint obj = new MinimizeDistanceToFarthestPoint();
        int pickBlock = obj.pickBlock(Set.of("school", "grocery"),
                List.of(Set.of("restaurant"),
                        Set.of("movie theater"),
                        Set.of("school","grocery"),
                        Collections.EMPTY_SET,
                        Set.of("school")));
        System.out.println(pickBlock);
    }
}
