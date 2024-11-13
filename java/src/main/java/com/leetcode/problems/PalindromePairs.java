import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PalindromePairs
 */
public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs s=new PalindromePairs();
        String[] words={"abcd","dcba","lls","s","sssll",""};
        List<List<Integer>> a = s.palindromePairs(words);
        System.out.println(a);
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                if (isPalindrome(prefix) && map.containsKey(suffix) && !map.get(suffix).equals(i)) {
                    // prefix is palid suffix match reversely
                    res.add(Arrays.asList(map.get(suffix), i));
                }
                if (isPalindrome(suffix) && map.containsKey(prefix) && j!=word.length()) {
                    // suffix is palid, and prefix match reversely
                    res.add(Arrays.asList(i, map.get(prefix)));
                }
            }
        }
        return res;
    }
}