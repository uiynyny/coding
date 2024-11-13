import java.util.Stack;

public class Calculator2 {
    public static void main(String[] args) {
        Calculator2 sol = new Calculator2();
        sol.calculate("3+2*2");
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
            } else {
                while (!ops.isEmpty() && preced(s.charAt(i), ops.peek())) {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private boolean preced(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return false;
        }
        return true;
    }

    private int eval(char op, int i, int j) {
        switch (op) {
            case '+':
                return i + j;
            case '*':
                return i * j;
            case '-':
                return j - i;
            case '/':
                return j / i;
        }
        return 0;
    }
}
