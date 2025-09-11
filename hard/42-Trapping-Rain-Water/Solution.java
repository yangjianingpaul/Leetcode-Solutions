
 /**
 * Problem: 42. Trapping Rain Water
 * Difficulty: hard
 * Approach: Two pointers advanced
 * Time: O(n), Space: O(n)
 */

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        if (height.length <= 2) {
            return sum;
        }

        int[] leftMaxs = new int[height.length];
        int[] rightMaxs = new int[height.length];
        leftMaxs[0] = 0;
        rightMaxs[height.length - 1] = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] <= height[i] && leftMaxs[i - 1] <= height[i]) {
                leftMaxs[i] = 0;
            } else {
                leftMaxs[i] = Math.max(height[i - 1], leftMaxs[i - 1]);
            }
        }

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] >= height[i + 1] && height[i] >= rightMaxs[i + 1]) {
                rightMaxs[i] = 0;
            } else {
                rightMaxs[i] = Math.max(height[i + 1], rightMaxs[i + 1]);
            }
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (leftMaxs[i] > 0 && rightMaxs[i] > 0) {
                sum += (Math.min(leftMaxs[i], rightMaxs[i]) - height[i]);
            }
        }

        return sum;
    }
}