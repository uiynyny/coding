/**
 * Backpack
 */
public class Backpack {

    public static void main(String[] args) {
        Backpack sol=new Backpack();
        sol.backPack(10, new int[]{3,4,8,5});
    }

    public int backPack(int m, int[] A) {
        int[] dp=new int[m+1];
        for(int i=0;i<A.length;i++){
            //forward would override larger size with small size being initialized.
            for(int j=dp.length-1;j>=A[i];j--){
                dp[j]=Math.max(dp[j], dp[j-A[i]]+A[i]);
            }
        }
        return dp[m];
    }
}