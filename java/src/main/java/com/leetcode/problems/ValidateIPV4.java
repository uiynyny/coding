package com.leetcode.problems;

public class ValidateIPV4 {
    public static void main(String[] args) {
        ValidateIPV4 o = new ValidateIPV4();
        o.isIPv4Address("64.233.161.00");
    }

    boolean isIPv4Address(String str) {
        String[] ss = str.split("\\.");
        if (ss.length != 4) return false;
        for (String s : ss) {
            if (s.isEmpty() || s.length() < 0 || s.length() > 3) return false;
            for (char c : s.toCharArray()) if (!Character.isDigit(c)) return false;
            int a = Integer.parseInt(s);
            int d= a==0? 1: (int) (Math.log10(a) + 1);
            if(d!=s.length())return false;
            if (a < 0 || a > 255)
                return false;
        }
        return true;
    }
}
