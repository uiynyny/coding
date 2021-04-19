package com.leetcode.problems;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens=new String[] {"4", "13", "5", "/", "+"};
        ReversePolishNotation obj=new ReversePolishNotation();
        System.out.println(obj.evalRPN(tokens));
    }

    public double evalRPN(String[] tokens) {
        double ret = 0;
        if (tokens.length == 0)
            return ret;
        String ops = "+-*/";

        Stack<String> stk = new Stack<>();
        for (String t : tokens) {
            if (!ops.contains(t))
                stk.push(t);
            else {
                double a = Double.parseDouble(stk.pop());
                double b = Double.parseDouble(stk.pop());
                switch (t) {
                    case "+":
                        stk.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stk.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stk.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stk.push(String.valueOf(b / a));
                        break;
                    default:
                        break;
                }
            }
        }
        ret=Double.parseDouble(stk.pop());
        return ret;
    }
}
