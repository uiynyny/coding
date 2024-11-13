import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Calculator sol=new Calculator();
        sol.calculate("1 + 1");
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;

            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                nums.push(num);
            } else if (s.charAt(i) == '(') {
                ops.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (ops.peek() != '(') {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && precedence(s.charAt(i), ops.peek())) {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                if(s.charAt(i)=='-'){
                    if(nums.isEmpty())nums.push(0);
                    else{
                        int index=i-1;
                        while(index>=0 && s.charAt(index)==' ') index--;
                        if(s.charAt(index)=='(')nums.push(0);
                    }
                }
                ops.push(s.charAt(i));
            }
        }
        while(!ops.isEmpty()){
            nums.push(eval(ops.pop(),nums.pop(),nums.pop()));
        }
        return nums.pop();
    }

    private boolean precedence(char a, char b) {
        if (b == '(' || b == ')')
            return false;
        else if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return false;
        }
        return true;
    }

    private int eval(char op, int i, int j) {
        switch (op) {
            case '+':
                return i + j;
            case '-':
                return j - i;
            case '*':
                return j * i;
            case '/':
                return j / i;
        }
        return 0;
    }
}
