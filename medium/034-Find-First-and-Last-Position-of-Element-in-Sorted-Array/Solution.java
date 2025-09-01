/**
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int head = 0;
        int end = nums.length - 1;
        int targetIndex = 0;
        int resultHead = -1;
        int resultEnd = -1;
        while (head < end) {
            int mid = (head + end) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (head == end) {
            targetIndex = head;
        }

        head = 0;
        end = targetIndex;

        while (head < end) {
            int mid = (head + end) / 2;
            if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] == target && nums[mid] != target) {
                resultHead = mid;
                break;
            } else {
                end = end - 1;
            }
        }

        if (head == end && nums[head] == target) {
            resultHead = head;
        }

        head = targetIndex;
        end = nums.length - 1;

        while (head < end) {
            int mid = (head + end) / 2;
            if (nums[mid] > target) {
                end = end - 1;
            } else if (nums[mid] == target && nums[mid + 1] != target) {
                resultEnd = mid;
                break;
            } else {
                head = head + 1;
            }
        }

        if (head == end && nums[head] == target) {
            resultEnd = head;
        }

        int[] result = new int[2];
        result[0] = resultHead;
        result[1] = resultEnd;
        return result;
    }
}