public class MaxProfit {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0)
            return 0;
        
        int[] dp=new int[prices.length];
        int result=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            dp[i]=Math.max(dp[i],dp[i-1]+prices[i]-prices[i-1]);
            result=Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        int maxProfit = sol.maxProfit(new int[] { 5,4,3,2,1});
        System.out.println(maxProfit);
    }
}