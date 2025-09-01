// class Solution {
// boolean result = false;

// public boolean canJump(int[] nums) {
// dfs(nums, 0);
// return result;
// }

// public void dfs(int[] nums, int index) {
// if (index == nums.length - 1) {
// result = true;
// return;
// }

// if (nums[index] == 0) {
// return;
// } else {
// for (int i = nums[index]; i >= 1; i--) {
// if (index + i < nums.length) {
// int newIndex = index + i;
// dfs(nums, newIndex);
// }
// }
// }
// }
// }

// class Solution {
// public boolean canJump(int[] nums) {
// return dfs(nums, nums.length - 1);
// }

// public boolean dfs(int[] nums, int index) {
// if (index == 0) {
// return true;
// }

// for (int i = index - 1; i >= 0; i--) {
// if (nums[i] >= index - i) {
// return dfs(nums, i);
// }
// }

// return false;
// }
// }

/**
 * Problem: 55. Jump Game
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        if (max == 0) {
            if (nums.length == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (max >= nums.length - 1) {
                return true;
            }

            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}