package 300. Longest Increasing Subsequence;

public class lengthOfLIS {
    
}

/**
 * Problem: 300. Longest Increasing Subsequence
 * Difficulty: Medium
 * Approach: 1D DP
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int size=nums.length;
        int[] list=new int[size];
        int result=0;
        for(int i=size-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    list[j]=Math.max(list[i]+1,list[j]);
                    result=Math.max(result,list[j]);
                }
            }
        }

        return result+1;
    }
}