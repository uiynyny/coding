package com.leetcode.problems;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest o = new FindKthLargest();
        int[] a = new int[] { 3, 2, 1, 5, 6, 4 };
        int k = 1;
        System.out.println(o.findKthLargest(a, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return getKth(nums,k, 0, nums.length - 1);
    }

    public int getKth(int[] a,int k, int start, int end) {
        int pivot=a[end];
        int left=start;
        int right=end;
        while(left<right){
            while(left<right && a[left]>pivot)left++;
            while(left<right && a[right]<=pivot)right--;
            if(left<right){
                swap(a,left,right);
            }
        }
        swap(a,left,end);
        if(k-1==left) return pivot;
        else if(left>k-1) return getKth(a, k, start, left-1);
        else return getKth(a, k, left+1, end);
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    void quickSort(int[] A, int start, int end) {
        if (start >= end)
            return;

        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot)
                left++;
            while (left <= right && A[right] > pivot)
                right--;
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
