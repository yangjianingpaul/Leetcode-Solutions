package maxDepth;

public class MaxDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(null);
        System.out.println(maxDepth);
    }
}

/**
 * Problem: 104. Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result = 1;

    public void dfs(TreeNode root, int layer) {
        result = Math.max(result, layer);
        if (root.left != null) {
            dfs(root.left, layer + 1);
        }

        if (root.right != null) {
            dfs(root.right, layer + 1);
        }

        return;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root, 1);
        return result;
    }
}