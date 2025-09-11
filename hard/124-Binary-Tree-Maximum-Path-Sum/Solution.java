/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * Problem: 124. Binary Tree Maximum Path Sum
 * Difficulty: hard
 * Approach: dfs
 * Time: O(n), Space: O(n)
 */

class Solution {
    int result;

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1000;
        }

        int lastMax = 0;
        int current = node.val;
        int leftMaxRoute = dfs(node.left);
        int rightMaxRoute = dfs(node.right);

        lastMax = Math.max(current, current + leftMaxRoute);
        lastMax = Math.max(lastMax, current + rightMaxRoute);

        result = Math.max(result, lastMax);
        result = Math.max(result, current + leftMaxRoute + rightMaxRoute);

        return lastMax;
    }

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        int dfs = dfs(root);
        return result;
    }
}