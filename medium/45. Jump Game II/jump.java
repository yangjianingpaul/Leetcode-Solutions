package 45. Jump Game II;

public class jump {
    
}

/**
 * Problem: 45. Jump Game II
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int jump(int[] nums) {
        int next = nums[0];
        int current = nums[0];
        int result = 1;
        if (nums.length == 1) {
            return 0;
        }
        if (current >= nums.length - 1) {
            return result;
        }

        for (int i = 1; i < nums.length; i++) {
            if (i > current) {
                current = next;
                result++;
            }
            next = Math.max(next, i + nums[i]);
            if (i + nums[i] >= nums.length - 1) {
                return result + 1;
            }
        }
        return 0;
    }
}