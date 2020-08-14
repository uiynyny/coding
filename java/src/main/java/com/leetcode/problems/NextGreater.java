package com.leetcode.problems;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NextGreater {
    public int solution(int N) {
        // calculate the sum of current N
        System.out.println(N);
        int temp=N;
        int sum=0;
        int digit=0;
        while(temp>0){
            sum+=(temp%10);
            temp/=10;
            digit++;
        }
        sum*=2;
        //
        int next=0;
        
        next=findNext(N,sum,digit);
        return next;
    }
    
    public int findNext(int N, int sum, int digit){
        //given 0
        if(sum==0)return 0;
        // find most significant bit as first bit
        int[] n=new int[digit];
        int ind=digit-1;
        while(N>0){
            n[ind--]=N%10;
            N/=10;
        }
        
        int msd=0;
        //correct digit number by given number has sum> digit sum
        while(sum>9*digit) {
            digit++;
            msd=1;
        }
        
        int[] res=new int[digit];
        for(int i=Math.min(n.length-1,digit-1);i>=0;i--){
            res[i]=n[i];
            sum-=n[i];
        }
        
        for(int i=digit-1;i>0;i--){
            if(sum>9){
                sum-=9-res[i];
                res[i]=9;
            }else{
                int rem=9-res[i];
                if(sum<=rem){
                    res[i]+=sum;
                    sum=0;
                }
                else{
                    sum-=rem;
                    res[i]=9;
                }
            }
        }
        int ret=0;
        for(int i:res){
            ret=ret*10+i;
        }
        return ret;
    }

    public static void main(String[] args) {
        NextGreater ng=new NextGreater();
        ng.solution(1);
    }
}