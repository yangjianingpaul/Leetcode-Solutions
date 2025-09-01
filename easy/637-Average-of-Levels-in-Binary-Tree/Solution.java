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
 * Problem: 637. Average of Levels in Binary Tree
 * Difficulty: Easy
 * Approach: Binary Tree BFS
 * Time: O(n), Space: O(n)
 */

class Solution {
    ArrayList<ArrayList<Long>> list = new ArrayList<ArrayList<Long>>();
    public void dfs(TreeNode node, int layer){
        if(node!=null){
            if(layer==list.size()){
                ArrayList<Long> nums=new ArrayList<Long>();
                nums.add((long)node.val);
                nums.add(1l);
                list.add(nums);
            }else{
                ArrayList<Long> oldList=list.get(layer);
                oldList.set(0,oldList.get(0)+node.val);
                oldList.set(1,oldList.get(1)+1l);
                list.set(layer,oldList);
            }

            dfs(node.left,layer+1);
            dfs(node.right,layer+1);
        }
        return;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root,0);
        List<Double> result=new ArrayList<Double>();
        for(int i=0;i<list.size();i++){
            Double num=list.get(i).get(0)*1.00000/list.get(i).get(1);
            result.add(num);
        }
        return result;
    }
}