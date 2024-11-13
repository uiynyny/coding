import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses s=new RemoveInvalidParentheses();
        List<String> removeInvalidParentheses = s.removeInvalidParentheses("()())");
        System.err.println(removeInvalidParentheses);
    }

    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();

        dfs(s, 0, 0, new char[] { '(', ')' }, res);
        return res;
    }

    private void dfs(String s, int start, int lastRemove, char[] pattern, List<String> res) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == pattern[0])
                count++;
            if (s.charAt(i) == pattern[1])
                count--;

            if (count < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j) != s.charAt(j - 1)))
                        dfs(s.substring(0, j) + s.substring(j + 1), i, j, pattern, res);
                }
                return;
            }
        }

        s=new StringBuilder(s).reverse().toString();
        if(pattern[0]=='('){
            dfs(s,0,0,new char[]{')','('},res);
        }else{
            res.add(s);
        }
    }
}
