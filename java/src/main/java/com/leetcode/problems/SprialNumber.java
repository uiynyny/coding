package com.leetcode.problems;

public class SprialNumber {
    public static void main(String[] args) {
        SprialNumber o=new SprialNumber();
        int[][] spiralNumbers = o.spiralNumbers(6);
    }
    int[][] spiralNumbers(int n) {
        int[][] ans=new int[n][n];
        int lb=0,ub=0,rb=n,bb=n;
        int f=1;
        while(lb<rb||ub<bb){
            for(int i=lb;i<rb;i++) ans[ub][i]=f++;
            ub++;
            for(int i=ub;i<bb;i++) ans[i][rb-1]=f++;
            rb--;
            if(ub>=bb||lb>=rb) break;
            for(int i=rb-1;i>=lb;i--) ans[bb-1][i]=f++;
            bb--;
            for(int i=bb-1;i>=ub;i--) ans[i][lb]=f++;
            lb++;
        }
        return ans;
    }

}
