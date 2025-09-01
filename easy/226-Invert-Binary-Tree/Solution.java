/**
 * Problem: 226. Invert Binary Tree
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

    public void dfs(TreeNode root) {
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }
        return;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        
        return root;
    }
}