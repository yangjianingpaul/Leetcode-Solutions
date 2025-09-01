package 117. Populating Next Right Pointers in Each Node II;

public class connect {
    
}

/**
 * Problem: 117. Populating Next Right Pointers in Each Node II
 * Difficulty: Medium
 * Approach: Binary Tree General
 * Time: O(n), Space: O(n)
 */

class Solution {
    ArrayList<Node> arrayList = new ArrayList<Node>();

    public void dfs(Node node, int layer) {
        if (node == null) {
            return;
        }

        if (layer >= arrayList.size()) {
            arrayList.add(node);
        } else {
            arrayList.get(layer).next = node;
            arrayList.set(layer, node);
        }

        dfs(node.left, layer + 1);
        dfs(node.right, layer + 1);
        return;
    }

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }
}