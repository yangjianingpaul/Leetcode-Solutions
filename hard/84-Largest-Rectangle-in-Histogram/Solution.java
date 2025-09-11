 /**
 * Problem: 84. Largest Rectangle in Histogram
 * Difficulty: hard
 * Approach: iteration
 * Time: O(n), Space: O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

        if (heights.length == 0) {
            return Integer.MIN_VALUE;
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
                index = i;
            }
        }

        int leftBiger = index - 1, rightBiger = index + 1;
        while (leftBiger >= 0) {
            if (heights[leftBiger] > min) {
                break;
            }
            leftBiger--;
        }

        while (rightBiger < heights.length) {
            if (heights[rightBiger] > min) {
                break;
            }
            rightBiger++;
        }

        int[] leftList = new int[0];
        int[] rightList = new int[0];
        int max = 0;

        if (leftBiger >= 0 && rightBiger >= heights.length) {
            leftList = Arrays.copyOfRange(heights, 0, leftBiger + 1);
            return Math.max(min * heights.length, largestRectangleArea(leftList));
        }

        if (leftBiger < 0 && rightBiger < heights.length) {
            rightList = Arrays.copyOfRange(heights, rightBiger, heights.length);
            return Math.max(min * heights.length, largestRectangleArea(rightList));
        }

        if (leftBiger >= 0 && rightBiger < heights.length) {
            leftList = Arrays.copyOfRange(heights, 0, leftBiger + 1);
            rightList = Arrays.copyOfRange(heights, rightBiger, heights.length);
            max = Math.max(largestRectangleArea(leftList), largestRectangleArea(rightList));
            return Math.max(max, min * heights.length);
        }

        return min * heights.length;
    }
}