/**
 * Problem: 162. Find Peak Element
 * Difficulty: Medium
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int head = 0;
        int end = nums.length - 1;
        int mid = (head + end) / 2;
        while (head <= end) {
            mid = (head + end) / 2;
            if (mid == head || mid == end) {
                break;
            }

            if (nums[mid] >= nums[head]) {
                head = mid;
                continue;
            }

            if (nums[mid] >= nums[end]) {
                end = mid;
            }
        }

        if (nums[head] > nums[end]) {
            return head;
        } else {
            return end;
        }
    }
}