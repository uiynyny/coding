import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int i : asteroids) {
            if (stk.isEmpty() || i > 0) {
                stk.push(i);
                continue;
            }
            while (true) {
                int pre = stk.peek();
                if (pre < 0) {
                    stk.push(i);
                    break;
                }
                if (pre == -i) {
                    stk.pop();
                    break;
                }
                if (pre > -i) {
                    break;
                }
                if (pre < -i) {
                    stk.pop();
                    if (stk.isEmpty()) {
                        stk.push(i);
                        break;
                    }
                }
            }
        }
        int [] res=new int[stk.size()];
        int i=stk.size()-1;
        while(!stk.isEmpty()){
            res[i--]=stk.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision s = new AsteroidCollision();
        int[] a = s.asteroidCollision(new int[] { 5, -5, 1 });
        System.out.println(a[0]);
    }

}
