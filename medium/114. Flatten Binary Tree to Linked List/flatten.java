package 114. Flatten Binary Tree to Linked List;

public class flatten {
    
}

/**
 * Problem: 114. Flatten Binary Tree to Linked List
 * Difficulty: Medium
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            flatten(root.right);
            flatten(root.left);
            if (root.left != null) {
                TreeNode treeNode = root.left;
                while (treeNode.right != null) {
                    treeNode = treeNode.right;
                }
                treeNode.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
        return;
    }
}