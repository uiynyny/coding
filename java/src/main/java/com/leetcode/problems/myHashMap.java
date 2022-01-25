package com.leetcode.problems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class myHashMap {
    HashMap<Integer, Integer> map = new HashMap<>();
    int shift = 0;

    public static void main(String[] args) {
        myHashMap o = new myHashMap();
        try {
            ObjectMapper obj = new ObjectMapper();
            JsonNode jsonNode = obj.readTree(new FileInputStream("src/main/resources/test-10.json"));
            JsonNode queryType = jsonNode.get("input").get("queryType");
            JsonNode query = jsonNode.get("input").get("query");
            String[] qt = new String[queryType.size()];
            int[][] q = new int[query.size()][];
            for (int i = 0; i < q.length; i++) {
                qt[i] = queryType.get(i).textValue();
                q[i] = new int[query.get(i).size()];
                for (int i1 = 0; i1 < query.get(i).size(); i1++) {
                    q[i][i1] = query.get(i).get(i1).intValue();
                }
            }

            String[] in = new String[]{"insert",
                    "insert",
                    "addToValue",
                    "addToKey",
                    "get"};
            int[][] ins = new int[][]{{1, 2},
                    {2, 3},
                    {2},
                    {1},
                    {3}};
            o.hashMap(qt, q);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    long hashMap(String[] qt, int[][] q) {
        long ans = 0;
        for (int i = 0; i < qt.length; i++) {

            switch (qt[i]) {
                case "insert":
                    insert(q[i]);
                case "get":
                    ans += get(q[i]);
                case "addToKey":
                    addToKey(q[i]);
                case "addToValue":
                    addToValue(q[i]);
            }
        }
        return ans;
    }

    private void addToValue(int[] q) {
        map.replaceAll((k, v) -> v + q[0]);
    }

    private void addToKey(int[] q) {
        if (map.size() == 0) shift = 0;
        else {
            shift += q[0];
        }
    }

    private long get(int[] q) {
        return map.getOrDefault(q[0] - shift, 0);
    }

    private void insert(int[] q) {
        map.put(q[0] + shift, q[1]);
    }
}
