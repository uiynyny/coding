package com.leetcode.problems;

import java.util.*;

public class SmallestStringWithSwap {
    public static void main(String[] args) {
        SmallestStringWithSwap obj = new SmallestStringWithSwap();
        String abdc = obj.swapLexOrder("abdc", new int[][]{{1, 4}, {3, 4}});
    }
    int[] parent;

    String swapLexOrder(String str, int[][] pairs) {
        // initialize parent array
        parent = new int[str.length()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        // union nodes
        for (int[] pair : pairs)
            union(pair[0] - 1, pair[1] - 1);
        // parent : list of children node
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < parent.length; i++) {
            if (!map.containsKey(find(i)))
                map.put(find(i), new ArrayList<>());
            map.get(find(i)).add(i);
        }
        // string to char array for manipulation
        char[] carr = str.toCharArray();
        // exchange all group of nodes to desired order
        for (int master : map.keySet()) {
            // all childrens for cur master
            List<Integer> nodes = map.get(master);
            // corresponding chars for nodes
            List<Character> chars = new ArrayList<>();
            for (int i : nodes)
                chars.add(carr[i]);
            // descending order
            chars.sort((a, b) -> b - a);
            for (int i = 0; i < chars.size(); i++) {
                carr[nodes.get(i)] = chars.get(i);
            }
        }
        return new String(carr);
    }

    // union operation for two node
    void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a != parent_b)
            parent[parent_a] = parent_b;
    }

    // find the parent for node
    int find(int node) {
        if (parent[node] == node)
            return node;
        // path compresion from linear structure to fan out structure
        return parent[node] = find(parent[node]);
    }
}
