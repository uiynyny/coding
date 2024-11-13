/**
 * MinimumWindowSubstring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring sol=new MinimumWindowSubstring();
        String minWindow = sol.minWindow("adobecodebanc", "ac");
        System.out.println(minWindow);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";

        int start = -1;
        int minLength = Integer.MAX_VALUE;
        int matchCount=t.length();
        int[] dict = new int[26];
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i)-'a']++;
        }
        int right=0, left=0;
        while(right<s.length()){
            while(right<s.length()&&matchCount>0){
                //keep extend to the right
                if(dict[s.charAt(right)-'a']-->0){
                    matchCount--;
                }
                right++;
            }
            while(matchCount==0){
                //currently mathced
                if(dict[s.charAt(left)-'a']++==0){
                    matchCount++;
                }
                left++;
            }
            if(right-left+1<minLength){
                start=left-1;
                minLength=right-left+1;
            }
        }
        return start==-1? "":s.substring(start, start+minLength);
    }
}