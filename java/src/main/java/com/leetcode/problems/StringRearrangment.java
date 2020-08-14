package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class StringRearrangment {
    public static void main(String[] args) {
        StringRearrangment o=new StringRearrangment();
        String[] a=new String[]{"ab","bb","aa"};
        o.stringsRearrangement(a);
    }

    boolean stringsRearrangement(String[] in) {
        boolean[] v=new boolean[in.length];
        dfs(in,new ArrayList<>(),v);
        return res;
    }
    boolean res=false;
    void dfs(String[] in, List<String> cur, boolean[] v){
        if(cur.size()==in.length){
            res=true;
            return;
        }
        for(int i=0;i<in.length;i++){
            if(!v[i] && (cur.isEmpty() ||isOneLetter(cur.get(cur.size()-1), in[i]))){
                v[i]=true;
                cur.add(in[i]);
                dfs(in,cur,v);
                cur.remove(cur.size()-1);
                v[i]=false;
            }
        }
    }

    boolean isOneLetter(String a, String b){
        int c=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))c++;
        }
        return c==1;
    }
}
