/**
 * Problem: 222. Count Complete Tree Nodes
 * Difficulty: Easy
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {
    int result = 0;

    public void dfs(TreeNode node) {
        if (node != null) {
            result++;
            dfs(node.left);
            dfs(node.right);
        }
        
        return;
    }

    public int countNodes(TreeNode root) {
        dfs(root);
        return result;
    }
}