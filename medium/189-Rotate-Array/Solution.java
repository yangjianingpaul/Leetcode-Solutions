/**
 * Problem: 189. Rotate Array
 * Difficulty: Medium
 * Approach: Array / String
 * Time: O(n), Space: O(n)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = length - k; i < 2 * length - k; i++) {
            if (i < length) {
                arrayList.add(nums[i]);
            } else {
                arrayList.add(nums[i - length]);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.get(i);
        }
    }
}