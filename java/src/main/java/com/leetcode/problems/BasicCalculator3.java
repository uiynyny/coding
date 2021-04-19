package com.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BasicCalculator3
 */
public class BasicCalculator3 {

    public static void main(String[] args) {
        BasicCalculator3 obj = new BasicCalculator3();
        String test = "(2+6* 3+5- (3*14/7+2)*5)+3";
        String test1 = "-1+4*-3/3";
        System.out.println(obj.calculateRec(test));
        System.out.println(obj.calculateRec(test1));
    }

    public double calculateRec(String s) {
        if (s == null)
            return 0;
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ')
                q.offer(c);
        }
        q.offer('+');
        return cal(q);
    }
    double cal(Queue<Character> q) {
        char op = '+';
        double num = 0, pre = 0, sum = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(')
                num=cal(q);
            else {
                switch (op) {
                    case '+':
                        sum += pre;
                        pre = num;
                        break;
                    case '-':
                        sum += pre;
                        pre = -num;
                        break;
                    case '*':
                        pre *= num;
                        break;
                    case '/':
                        if (num == 0)
                            break;
                        pre /= num;
                        break;
                    default:
                        break;
                }
                if (c == ')')
                    break;
                op = c;
                num = 0;
            }
        }
        return sum + pre;
    }

    public double calculate(String s) {
        Deque<Double> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        // if negative number presented need to push 0 before evaluate -
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;

            // digit case
            if (Character.isDigit(s.charAt(i))) {
                double num = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                nums.push(num);
            }
            // opratior case
            else {
                char op = s.charAt(i);
                if (op == '(')
                    ops.push(op);
                else if (op == ')') {
                    while (ops.peek() != '(')
                        nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                    ops.pop(); // pop (
                } else {
                    while (!ops.isEmpty() && precedence(op, ops.peek()))
                        nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                    ops.push(op);
                }
            }
        }
        while (!ops.isEmpty())
            nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
        return nums.pop();
    }

    double eval(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }
}