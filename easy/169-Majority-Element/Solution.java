import java.util.Arrays;

/**
 * Problem: 169. Majority Element
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}