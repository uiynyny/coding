import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct sol=new LengthOfLongestSubstringKDistinct();
        sol.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16);
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s.length()==0)return 0;
        // char to # appears
        Map<Character,Integer> map=new HashMap<>();

        int left=0,right=0,maxLength=0;
        for(;left<s.length();left++){
            while(right<s.length() && map.size()<=k){
                //valid
                int count = map.getOrDefault(s.charAt(right), 0)+1;
                map.put(s.charAt(right),count);
                right++;
            }
            if(map.size()>k){
                maxLength=Math.max(right-left-1,maxLength);
            }else{
                //valid
                maxLength=Math.max(right-left,maxLength);
            }
            while(map.size()>k){
                int count = map.getOrDefault(s.charAt(left),0)-1;
                if(count==0){
                    map.remove(s.charAt(left));
                }else{
                    map.put(s.charAt(left++),count);
                }
            }
        }
        return maxLength;
    }
}
