package getMinimumDifference;

import java.util.ArrayList;

public class GetMinimumDifference {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int minimumDifference = solution.getMinimumDifference(null);
        System.out.println(minimumDifference);
    }
}

/**
 * Problem: 530. Minimum Absolute Difference in BST
 * Difficulty: Easy
 * Approach: Binary Search Tree
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

    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }

        arrayList.add(node.val);

        if (node.right != null) {
            dfs(node.right);
        }

        return;
    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result = Math.min(result, arrayList.get(i + 1) - arrayList.get(i));
        }
        return result;
    }
}