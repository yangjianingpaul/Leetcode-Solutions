package 101. Symmetric Tree;

public class isSymmetric {
    
}

/**
 * Problem: 101. Symmetric Tree
 * Difficulty: Easy
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {

    public boolean dfs(TreeNode node1, TreeNode node2) {

        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
            } else {
                return false;
            }
        } else if (node1 == null && node2 == null) {
            return true;
        }

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
}