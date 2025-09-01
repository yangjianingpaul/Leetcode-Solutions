package 215. Kth Largest Element in an Array;

public class findKthLargest {
    
}

/**
 * Problem: 215. Kth Largest Element in an Array
 * Difficulty: Medium
 * Approach: Heap
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}