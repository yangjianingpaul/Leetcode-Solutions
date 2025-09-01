package 74. Search a 2D Matrix;

public class searchMatrix {
    
}

/**
 * Problem: 74. Search a 2D Matrix
 * Difficulty: Medium
 * Approach: Binary Search
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowHead = 0;
        int rowEnd = matrix.length - 1;
        int colHead = 0;
        int colEnd = matrix[0].length - 1;
        while (rowHead < rowEnd) {
            int mid = (rowHead + rowEnd) / 2;
            if (matrix[mid][0] > target) {
                rowEnd = mid - 1;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
                rowHead = mid + 1;
            } else {
                rowHead = mid;
                rowEnd = rowHead;
            }
        }

        while (colHead < colEnd) {
            int mid = (colEnd + colHead) / 2;
            if (matrix[rowHead][mid] > target) {
                colEnd = mid - 1;
            } else if (matrix[rowHead][mid] < target) {
                colHead = mid + 1;
            } else {
                return true;
            }
        }

        if (matrix[rowHead][colHead] == target) {
            return true;
        } else {
            return false;
        }

    }
}