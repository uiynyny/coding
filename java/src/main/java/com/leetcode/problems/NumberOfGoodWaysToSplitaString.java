import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodWaysToSplitaString {
    public static void main(String[] args) {
        NumberOfGoodWaysToSplitaString sol=new NumberOfGoodWaysToSplitaString();
        sol.numSplits("aacaba");
    }

    public int numSplits(String s) {
        Map<Character,Integer> h1=new HashMap<>();
        Map<Character,Integer> h2=new HashMap<>();
 
        for(int i=0;i<s.length();i++){
            h2.put(s.charAt(i),h2.getOrDefault(s.charAt(i),0)+1);
        }
        
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            h1.put(s.charAt(i),h1.getOrDefault(s.charAt(i),0)+1);
            if(h2.get(s.charAt(i))-1==0){
                h2.remove(s.charAt(i));
            }else{
                h2.put(s.charAt(i),h2.get(s.charAt(i))-1);
            }
            
            if(h1.size()==h2.size()){
                count++;
            }
        }
        return count;
    }
}
