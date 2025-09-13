
 /**
 * Problem: 239. Sliding Window Maximum
 * Difficulty: hard
 * Approach: Deque optimization
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!arrayDeque.isEmpty() && arrayDeque.peekFirst() < i - k + 1) {
                arrayDeque.pollFirst();
            }

            while (!arrayDeque.isEmpty() && nums[arrayDeque.peekLast()] < nums[i]) {
                arrayDeque.pollLast();
            }

            arrayDeque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[arrayDeque.peekFirst()];
            }
        }

        return result;
    }
}