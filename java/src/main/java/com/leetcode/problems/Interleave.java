import java.util.Arrays;

/**
 * Interleave
 */
public class Interleave {

    public static void main(String[] args) {
        Interleave sol= new Interleave();
        int[] A={-1,2,-3,-4,5,6};
        sol.rerange(A);
        System.out.println(Arrays.toString(A));
    }

    public void rerange(int[] A){
        if(A==null||A.length==0)return;

        int left=0, right=A.length-1;

        while(left<=right){
            while(left<=right && A[left]<0)left++;
            while(left<=right && A[right]>0) right--;
            if(left<right){
                swap(A,left,right);
                left++;
                right--;
            }
        }
        if(left>A.length-left){
            // #neg > #pos
            arrange(A,1,A.length-1);
        }else if(left<A.length-left){
            arrange(A,0,A.length-2);
        }else{
            arrange(A,0,A.length-1);
        }
    }

    private void arrange(int[] A, int start, int end){
        while(start<=end){
            swap(A,start,end);
            start+=2;
            end-=2;
        }
    }
    private void swap(int[] A, int i, int j){
        int t=A[i];
        A[i]=A[j];
        A[j]=t;
    }
}