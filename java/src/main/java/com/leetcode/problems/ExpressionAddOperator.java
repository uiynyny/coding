import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    public static void main(String[] args) {
        ExpressionAddOperator s=new ExpressionAddOperator();
        List<String> a = s.addOperators("123", 6);
        System.out.println(a);
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, new StringBuilder(), 0, 0, 0, res);
        return res;
    }

    private void dfs(String s, int t, StringBuilder sb, int pos, long tmp, long last, List<String> res) {
        if (pos == s.length()) {
            if (t == tmp)
                res.add(sb.toString());
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(pos) == '0' && i != pos) {
                break;
            }
            long val = Long.valueOf(s.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                dfs(s, t, sb.append(val), i + 1, tmp + val, val, res);
                sb.setLength(len);
            } else {
                dfs(s, t, sb.append('+').append(val), i + 1, tmp + val, val, res);
                sb.setLength(len);
                dfs(s, t, sb.append('-').append(val), i + 1, tmp - val, -val, res);
                sb.setLength(len);
                dfs(s, t, sb.append('*').append(val), i + 1, tmp - last + last * val, last * val, res);
                sb.setLength(len);
            }
        }
    }
}
