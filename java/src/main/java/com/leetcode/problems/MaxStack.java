import java.util.Stack;

public class MaxStack {
    public static void main(String[] args) {

    }

    Stack<Integer> stk;
    Stack<Integer> maxStk;

    public MaxStack() {
        // do intialization if necessary
        stk = new Stack<>();
        maxStk = new Stack<>();
    }

    /*
     * @param number: An integer
     * 
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        int max = maxStk.isEmpty()? x:maxStk.peek();
        maxStk.push(Math.max(max,x));
        stk.push(x);
    }

    public int pop() {
        // write your code here
        maxStk.pop();
        return stk.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stk.peek();
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        return maxStk.peek();
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        Stack<Integer> temp=new Stack<>();
        int max=maxStk.peek();
        while(top()!=max) temp.push(pop());
        pop();
        while(!temp.isEmpty()) push(temp.pop());
        return max;
    }
}