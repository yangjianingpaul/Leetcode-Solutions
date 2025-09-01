package 103. Binary Tree Zigzag Level Order Traversal;

public class zigzagLevelOrder {
    
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
 * Problem: 103. Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Approach: Binary Tree BFS
 * Time: O(n), Space: O(n)
 */

class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public void dfs(TreeNode node,int layer){
        if(node!=null){
            if(layer==result.size()){
                List<Integer> nums=new ArrayList<Integer>();
                nums.add(node.val);
                result.add(nums);
            }else{
                List<Integer> nums=result.get(layer);
                if(layer%2==0){
                    nums.add(node.val);
                }else{
                    nums.add(0,node.val);
                }
                result.set(layer,nums);
            }

            dfs(node.left,layer+1);
            dfs(node.right,layer+1);
        }
        return;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root,0);
        return result;
    }
}