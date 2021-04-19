package com.leetcode.problems;

public class AlternatingBit {
    public static void main(String[] args) {
        AlternatingBit o=new AlternatingBit();
        System.out.println( o.solve(1431655765));
    }
    boolean solve(int n){
        int last=n%2;
        int prev=1-last;
        while(n>0){
            int bit=n%2;
            System.out.println(bit);
            if(bit==prev){
                return false;
            }
            prev=bit;
            n=n/2;
        }
        return true;
    }
}
