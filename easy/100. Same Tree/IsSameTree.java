package isSameTree;

public class IsSameTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean sameTree = solution.isSameTree(null, null);
        System.out.println(sameTree);
    }
}

/**
 * Problem: 100. Same Tree
 * Difficulty: Easy
 * Approach: Binary Tree General
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else {
            if (q.val == p.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
    }
}