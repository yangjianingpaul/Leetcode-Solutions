package 112. Path Sum;

public class hasPathSum {
    
}

/**
 * Problem: 112. Path Sum
 * Difficulty: Easy
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {
    public boolean dfs(int sum, TreeNode node, int targetSum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                return true;
            } else {
                return false;
            }
        }

        boolean left = false;
        boolean right = false;
        if (node.left != null) {
            left = dfs(sum, node.left, targetSum);
        }

        if (node.right != null) {
            right = dfs(sum, node.right, targetSum);
        }

        return left || right;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(0, root, targetSum);
    }
}