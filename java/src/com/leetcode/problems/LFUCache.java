package com.leetcode.problems;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer,Integer> valueMap;
    Map<Integer,Integer> countMap;
    Map<Integer,LinkedHashSet<Integer>> orderMap;
    int cap;
    int min;
    public LFUCache(int capacity) {
        cap=capacity;
        min=0;
        valueMap=new HashMap<>();
        countMap=new HashMap<>();
        orderMap=new HashMap<>();
        orderMap.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!valueMap.containsKey(key)) return -1;
        int count=countMap.get(key);
        countMap.put(key,count+1);
        if(count==min&&orderMap.get(count).size()==0)
            min++;
        if(!orderMap.containsKey(count+1))
            orderMap.put(count+1,new LinkedHashSet<>());
        orderMap.get(count+1).add(key);
        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(cap<1)return;
        if(valueMap.containsKey(key)){
            valueMap.put(key,value);
            get(key);
            return;
        }
        if(valueMap.size()>=cap){
            int del=orderMap.get(min).iterator().next();
            orderMap.get(min).remove(del);
            valueMap.remove(del);
            countMap.remove(del);
        }
        valueMap.put(key,value);
        countMap.put(key,1);
        min=1;
        orderMap.get(min).add(key);
    }

    /**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    public static void main(String[] args) {
        
    }
}
