/**
 * Problem: 35. Search Insert Position
 * Difficulty: Easy
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (head <= end) {
            mid = (head + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                return mid;
            }
        }

        if (nums[mid] > target) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}