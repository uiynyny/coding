package com.leetcode.problems;

public class ValidAnagram {
    public static void main(String[] args) {
        String a="qazxswedc";
        String b="zxcswqade";
        ValidAnagram obj=new ValidAnagram();
        System.out.println(obj.isAnagram(a, b));
    }

    public boolean isAnagram(String a, String b){
        int[] buck=new int[256];
        for(char c:a.toCharArray()) buck[c]++;
        for(char c:b.toCharArray()){
            if(buck[c]==0)return false;
            buck[c]--;
        }
        return true;
    }
}
