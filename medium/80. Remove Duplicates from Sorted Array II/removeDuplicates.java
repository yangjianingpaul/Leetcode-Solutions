package 80. Remove Duplicates from Sorted Array II;

public class removeDuplicates {
    
}

/**
 * Problem: 80. Remove Duplicates from Sorted Array II
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {
                sum++;
                if (sum < 3) {
                    index++;
                    nums[index] = nums[i];
                }
            } else {
                index++;
                nums[index] = nums[i];
                sum = 1;
            }
        }
        return index + 1;
    }
}