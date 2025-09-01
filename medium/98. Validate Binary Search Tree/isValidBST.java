package 98. Validate Binary Search Tree;

public class isValidBST {
    
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
 * Problem: 98. Validate Binary Search Tree
 * Difficulty: Medium
 * Approach: Binary Search Tree
 * Time: O(n), Space: O(n)
 */

class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    boolean flag=true;
    public void dfs(TreeNode node){
        if(node!=null){
            dfs(node.left);
            if(list.size()==0||list.get(list.size()-1)<node.val){
                list.add(node.val);
            }else{
                flag=false;
                return;
            }
            dfs(node.right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }
}