package twoSum;
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(null, 0);
    }
}

/**
 * Problem: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Approach: Two Pointers
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int minus = target - numbers[i];
            int head = i + 1;
            int end = numbers.length - 1;
            while (head <= end) {
                int mid = (head + end) / 2;
                if (numbers[mid] < minus) {
                    head = mid + 1;
                } else if (numbers[mid] > minus) {
                    end = mid - 1;
                } else {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                }
            }
        }
        return result;
    }
}