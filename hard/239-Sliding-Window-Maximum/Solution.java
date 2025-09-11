
 /**
 * Problem: 239. Sliding Window Maximum
 * Difficulty: hard
 * Approach: Deque optimization
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        ArrayList<Integer> window = new ArrayList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (window.get(0) == nums[left]) {
                    window.remove(0);
                }

                left++;
            }

            for (int j = window.size() - 1; j >= 0; j--) {
                if (window.get(j) < nums[i]) {
                    window.removeLast();
                } else {
                    break;
                }
            }

            window.add(nums[i]);

            if (i >= k - 1) {
                result[i + 1 - k] = window.get(0);
            }
        }

        return result;
    }
}