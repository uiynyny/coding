import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
     public List<String> letterCasePermutation(String S) {
        // write your code here
        List<String> result=new ArrayList<>();
        bt(S, 0, "", result);
        return result;
    }
    
    private void bt(String s, int i, String cur, List<String> result) {
        if (i == s.length()) {
            System.out.println(cur);
            result.add(cur);
            return;
        }
        if (Character.isAlphabetic(s.charAt(i))) {
            bt(s, i + 1, cur + Character.toLowerCase(s.charAt(i)), result);
            bt(s, i + 1, cur + Character.toUpperCase(s.charAt(i)), result);
            }else{
            bt(s,i+1,cur+s.charAt(i),result);
            }
    }
}