import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static void main(String[] args) {
        CharacterReplacement sol=new CharacterReplacement();
        int characterReplacement = sol.characterReplacement("AABABBA",1);
        System.out.println(characterReplacement);
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int right = 0, left = 0, mostFreq = 0;
        for (; left < s.length(); left++) {
            while (right < s.length() && right - left - mostFreq <= k) {
                // right not reach to end and there are <=k distinct char between left and right
                int count = map.getOrDefault(s.charAt(right), 0) + 1;
                map.put(s.charAt(right), count);
                mostFreq = Math.max(mostFreq, count);
                right++;
            }
            result = Math.max(result, right - left - (right - left - mostFreq > k ? 1 : 0));
            // forward left
            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        }
        return result;
    }
}