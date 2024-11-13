public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static void main(String[] args) {
        Solution s=new Solution();
        int longestIncreasingSubsequence = s.longestIncreasingSubsequence(new int[]{88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59});
        System.out.println(longestIncreasingSubsequence);
    }
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums.length==0)return 0;
        int[] res=new int[nums.length];
        res[0]=nums[0];
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<res[0]) res[0]=nums[i];
            else if(nums[i]> res[index])res[++index]=nums[i];
            else res[bs(res,0,index,nums[i])]=nums[i];
            print(res);
        }
        return index+1;
    }
    private int bs(int[] n, int left,int right,int target){
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(n[mid]==target)return mid;
            else if(n[mid]<target) left=mid;
            else right=mid;
        }
        return n[left]>=target? left:right;
    }
    private void print(int[] n){
        for(int i:n){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}