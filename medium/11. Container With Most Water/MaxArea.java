package maxArea;
public class MaxArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxArea = solution.maxArea(null);
        System.out.println(maxArea);
    }
}

/**
 * Problem: 11. Container With Most Water
 * Difficulty: Medium
 * Approach: Two Pointers
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int maxArea(int[] height) {
        int head = 0;
        int end = height.length - 1;
        int result = 0;
        while (head <= end) {
            int wide = 0;
            int length = end - head;
            if (height[head] < height[end]) {
                wide = height[head];
                head++;
            } else {
                wide = height[end];
                end--;
            }
            result = Math.max(result, wide * length);
        }
        return result;
    }
}