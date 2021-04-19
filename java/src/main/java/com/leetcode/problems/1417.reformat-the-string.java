package com.leetcode.problems;

/*
 * @lc app=leetcode id=1417 lang=java
 *
 * [1417] Reformat The String
 *
 * https://leetcode.com/problems/reformat-the-string/description/
 *
 * algorithms
 * Easy (55.03%)
 * Total Accepted:    19K
 * Total Submissions: 34.6K
 * Testcase Example:  '"a0b1c2"'
 *
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of
 * lowercase English letters and digits).
 * 
 * You have to find a permutation of the string where no letter is followed by
 * another letter and no digit is followed by another digit. That is, no two
 * adjacent characters have the same type.
 * 
 * Return the reformatted string or return an empty string if it is impossible
 * to reformat the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c".
 * "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by
 * digits.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by
 * characters.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "ab123"
 * Output: "1a2b3"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 * 
 * 
 */
import java.util.*;

class ReformatString {
    public String reformat(String s) {
        if(s.length()==0)return "";
        List<Integer> alphapos=new ArrayList();
        List<Integer> numpos=new ArrayList();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))numpos.add(i);
            else alphapos.add(i);
        }
        if(Math.abs(alphapos.size()-numpos.size())>1)return "";
        List<Integer> list1,list2;
        if(alphapos.size()>numpos.size()){
            list1=alphapos;
            list2=numpos;
        }else{
            list1=numpos;
            list2=alphapos;
        }
        boolean alt=true;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(alt? s.charAt(list1.remove(0)):s.charAt(list2.remove(0)));
            alt=!alt;
        }
        return sb.toString();
    }
}
