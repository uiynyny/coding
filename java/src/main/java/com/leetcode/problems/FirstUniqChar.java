import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar sol=new FirstUniqChar();
        char firstUniqChar = sol.firstUniqChar("abaccdeff");
        System.out.println(firstUniqChar);
    }

    public char firstUniqChar(String str){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c: str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: map.keySet()){
            if(map.get(c)==1){
                return c;
            }
        }
        return '-';
    }
}
