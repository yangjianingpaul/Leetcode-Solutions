package 129. Sum Root to Leaf Numbers;

public class sumNumbers {
    
}

/**
 * Problem: 129. Sum Root to Leaf Numbers
 * Difficulty: Medium
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {
    int result = 0;

    public void dfs(TreeNode node, int sum) {
        if (node != null) {
            sum = sum * 10 + node.val;
            if (node.left == null && node.right == null) {
                result += sum;
            }

            dfs(node.left, sum);
            dfs(node.right, sum);
        }
        return;
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }
}