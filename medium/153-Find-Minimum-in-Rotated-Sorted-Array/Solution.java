/**
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int findMin(int[] nums) {
        int head = 0;
        int end = nums.length - 1;
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums.length == 1) {
            return nums[0];
        }
        while (head <= end) {
            int mid = (head + end) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else {
                if (nums[mid] > nums[end]) {
                    head = mid + 1;
                } else if (nums[mid] < nums[head]) {
                    end = mid - 1;
                } else {
                    return nums[head];
                }
            }
        }

        return -1;
    }
}