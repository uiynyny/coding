import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum s=new SlidingWindowMaximum();
        List<Integer> a = s.maxSlidingWindow(new int[]{1,2,3,1,2,3}, 3);
        System.out.println(a);
    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> monoq=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if(nums.length==0)return res;
        for(int i=0;i<nums.length;i++){
            //desc mono queue
            while(!monoq.isEmpty() && nums[i]>nums[monoq.peekLast()]){
                monoq.removeLast();
            }
            monoq.addLast(i);
            // there are k element in q, get first as ans, dont pop as next seq will need it 
            if(i+1>=k){
                res.add(nums[monoq.peekFirst()]);
            }
            if(monoq.peekFirst()==i-k+1){
                monoq.removeFirst();
            }
        }
        return res;
    }
}
