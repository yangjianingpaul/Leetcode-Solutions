import javax.swing.tree.TreeNode;

/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 * Difficulty: Easy
 * Approach: Binary Tree
 * Time: O(n), Space: O(n)
 */

class Solution {
    TreeNode result = null;

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node != null) {
            boolean current = false;
            if (node == p || node == q) {
                current = true;
            }

            boolean leftTree = dfs(node.left, p, q);
            boolean rightTree = dfs(node.right, p, q);

            if (result == null) {
                if (current) {
                    if (leftTree || rightTree) {
                        result = node;
                    }
                } else {
                    if (leftTree && rightTree) {
                        result = node;
                    }
                }
            }

            return current || leftTree || rightTree;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean dfs = dfs(root, p, q);
        return result;
    }
}