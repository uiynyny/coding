package com.leetcode.problems;
/*
* Concatenate sum: {a,b}
* aa+ab+ba+bb
* = a*10an+a*10bn+(a+b)+b*10an+b*10bn+(a+b)
* = (a+b)*len+a(10an+10bn)+b(10an+a0bn)
* = (a+b)*len+(a+b)(10an+10bn)
* = (a+b)[len+(10an+10bn] QED  s.t. sum of array * (arr length + sum of offset for each num) */
public class ConcatenationSum {
    public static void main(String[] args) {
        ConcatenationSum obj=new ConcatenationSum();
        int[] a=new int[]{10,21,324};
        long l = obj.concatenationsSum(a);
    }
    long concatenationsSum(int[] a) {
        long lowSum=0;
        long offsetSum=0;
        for(int n:a){
            lowSum+=n;
            int len=String.valueOf(n).length();
            long offset=iPower(10,len);
            offsetSum+=offset;
        }
        return lowSum*(a.length+offsetSum);
    }

    long iPower(long base, int power) {
        long res=1;
        while(power-->0){
            res*=base;
        }
        return res;
    }
}
