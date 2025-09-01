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

import java.util.ArrayList;

/**
 * Problem: 230. Kth Smallest Element in a BST
 * Difficulty: Medium
 * Approach: Binary Search Tree
 * Time: O(n), Space: O(n)
 */

class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    public void dfs(TreeNode node){
        if(node!=null){
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }else{
            return;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return list.get(k-1);
    }
}