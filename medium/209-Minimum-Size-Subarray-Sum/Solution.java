/**
 * Problem: 209. Minimum Size Subarray Sum
 * Difficulty: Medium
 * Approach: Sliding Window
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int head = 0;
        int end = head + 1;
        int sum = nums[head];
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while (head <= end && end <= nums.length) {
            if (sum < target) {
                if (end < nums.length) {
                    sum += nums[end];
                }
                end++;
            } else {
                flag = true;
                result = Math.min(end - head, result);
                sum -= nums[head];
                head++;
            }
        }

        if (flag) {
            return result;
        } else {
            return 0;
        }
    }
}