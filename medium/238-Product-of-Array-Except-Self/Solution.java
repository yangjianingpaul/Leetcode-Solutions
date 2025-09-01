/**
 * Problem: 238. Product of Array Except Self
 * Difficulty: Medium
 * Approach: HashMap for O(n) solution
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int nums1[]=new int[length];
        int nums2[]=new int[length];
        nums1[0]=1;
        nums2[length-1]=1;
        for(int i=1;i<length;i++){
            nums1[i]=nums1[i-1]*nums[i-1];
        }

        for(int i=length-2;i>=0;i--){
            nums2[i]=nums2[i+1]*nums[i+1];
        }

        for(int i=0;i<length;i++){
            nums[i]=nums1[i]*nums2[i];
        }
        return nums;
    }
}