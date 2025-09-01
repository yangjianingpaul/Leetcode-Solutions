package 102. Binary Tree Level Order Traversal;

public class levelOrder {
    
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
 * Problem: 102. Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Approach: Binary Tree BFS
 * Time: O(n), Space: O(n)
 */

class Solution {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public void dfs(TreeNode node,int layer){
        if(node!=null){
            if(layer==list.size()){
                ArrayList<Integer> nums=new ArrayList<Integer>();
                nums.add(node.val);
                list.add(nums);
            }else{
                List<Integer> arrayList = list.get(layer);
                arrayList.add(node.val);
                list.set(layer,arrayList);
            }

            dfs(node.left,layer+1);
            dfs(node.right,layer+1);
        }
        return;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return list;
    }
}