package com.leetcode.problems;

public class BuildPalidrome {
    public static void main(String[] args) {
        BuildPalidrome o=new BuildPalidrome();
        String s = o.buildPalindrome("abccba");
    }
    String buildPalindrome(String st) {
        int len=0;
        for(int i=0;i<st.length();i++){
            int len1=expand(st,i,i);
            int len2=expand(st,i,i+1);
            int ml=Math.max(len1,len2);
            if(ml>len && i+ ml/2 >=st.length()-1){
                len=ml;
            }else{ break;}
        }
        StringBuilder sb=new StringBuilder(st);
        for(int i=st.length()-1-len;i>=0;i--) sb.append(st.charAt(i));
        return sb.toString();
    }

    int expand(String s,int i, int j){
        while(i>=0 && j < s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

}
