package 108. Convert Sorted Array to Binary Search Tree;

public class sortedArrayToBST {
    
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Problem: 108. Convert Sorted Array to Binary Search Tree
 * Difficulty: Easy
 * Approach: Divide & Conquer
 * Time: O(n), Space: O(n)
 */

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode();
        int mid = nums.length / 2;
        treeNode.val = nums[mid];

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }

        int[] right = new int[nums.length - mid - 1];
        for (int i = 0; i < nums.length - mid - 1; i++) {
            right[i] = nums[i + mid + 1];
        }

        if (left.length > 0) {
            treeNode.left = sortedArrayToBST(left);
        }

        if (right.length > 0) {
            treeNode.right = sortedArrayToBST(right);
        }
        return treeNode;
    }
}