/**
 * Problem: 199. Binary Tree Right Side View
 * Difficulty: Medium
 * Approach: Binary Tree BFS
 * Time: O(n), Space: O(n)
 */

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();

    public void dfs(TreeNode root, Integer layer) {
        if (result.size() == layer) {
            result.add(root.val);
        } else {
            result.set(layer, root.val);
        }

        if (root.left != null) {
            dfs(root.left, layer + 1);
        }

        if (root.right != null) {
            dfs(root.right, layer + 1);
        }
        return;
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        
        dfs(root, 0);
        return result;
    }
}