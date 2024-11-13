import java.util.TreeMap;
import java.util.Map.Entry;

public class OddEvenJump {
    public static void main(String[] args) {
        OddEvenJump sol = new OddEvenJump();
        int a = sol.oddEvenJumps(new int[] { 2,3,1,1,4});
        System.out.println(a);
    }

    public int oddEvenJumps(int[] arr) {
        boolean[] higher = new boolean[arr.length], lower = new boolean[arr.length];
        higher[arr.length - 1] = lower[arr.length - 1] = true;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(arr[arr.length - 1], arr.length - 1);
        int count = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            Entry<Integer, Integer> hi = tmap.ceilingEntry(arr[i]);
            Entry<Integer, Integer> lo = tmap.floorEntry(arr[i]);
            if (hi != null)
                higher[i] = lower[(int)hi.getValue()];
            if (lo != null)
                lower[i] = higher[(int)lo.getValue()];
            
            if(higher[i])count++;
            tmap.put(arr[i], i);
        }
        return count;
    }
}
