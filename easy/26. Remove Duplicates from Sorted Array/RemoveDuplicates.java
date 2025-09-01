package removeDuplicates;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int removeDuplicates = solution.removeDuplicates(null);
        System.out.println(removeDuplicates);
    }
}

/**
 * Problem: 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}