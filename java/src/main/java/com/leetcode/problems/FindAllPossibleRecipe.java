package com.leetcode.problems;

import java.util.*;

public class FindAllPossibleRecipe {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //raw material
        Set<String> raw = new HashSet();
        for (String supp : supplies) raw.add(supp);

        // recipe to material
        Map<Integer, Set<String>> rec = new HashMap();
        for (int i = 0; i < ingredients.size(); i++) rec.put(i, new HashSet(ingredients.get(i)));

        // topo order
        int[] indegree = new int[recipes.length];

        for (int key : rec.keySet()) {
            for (int i = 0; i < recipes.length; i++) {
                if (rec.get(key).contains(recipes[i])) indegree[key]++;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (indegree[a] - indegree[b]));
        for (int i = 0; i < recipes.length; i++)
            pq.add(i);
        List<String> res=new ArrayList<>();
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (raw.containsAll(rec.get(poll))) {
                raw.add(recipes[poll]);
                res.add(recipes[poll]);
            }
        }
        return res;
    }
}