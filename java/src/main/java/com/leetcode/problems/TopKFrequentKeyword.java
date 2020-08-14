package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// "static void main" must be defined in a public class.
public class TopKFrequentKeyword {
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        List<String> solve1 = solve(k1, keywords1, reviews1);
        List<String> solve2 = solve(k2, keywords2, reviews2);
    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> keyList = Arrays.asList(keywords);
        for (String review : reviews) {// loop single review
            String[] sequence = review.split("\\s+");
            HashSet<String> set = new HashSet<>(); //use set to prevent multiple count of a single review
            for (String word : sequence) {// loop single word
                word = word.toLowerCase();
                if (keyList.contains(word) && !set.contains(word)) {
                    hm.put(word, hm.getOrDefault(word, 0) + 1);
                    set.add(word);
                }
            }
        }
        List<String> res = new ArrayList<>(hm.keySet());
        Collections.sort(res,(a,b)->hm.get(a).equals(hm.get(b))? a.compareTo(b):hm.get(b)-hm.get(a));
        return res.subList(0, k);
    }
}