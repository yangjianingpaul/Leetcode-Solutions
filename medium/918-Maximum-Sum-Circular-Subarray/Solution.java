/**
 * Problem: 918. Maximum Sum Circular Subarray
 * Difficulty: Medium
 * Approach: Kadane's Algorithm
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int maxSubarraySum(int[] nums,int index){
        int sum=nums[index];
        int result=sum;
        for(int i=index+1;i<index+nums.length;i++){
            int j=i%nums.length;
            if(sum<0){
                sum=nums[j];
            }else{
                sum+=nums[j];
            }
            result=Math.max(result,sum);
        }
        return result;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int result=nums[0];
        for(int i=0;i<nums.length;i++){
            int maxSum=maxSubarraySum(nums,i);
            result=Math.max(result,maxSum);
        }

        return result;
    }
}