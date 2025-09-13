
/**
 * Problem: 297. Serialize and Deserialize Binary Tree
 * Difficulty: hard
 * Approach: dfs
 * Time: O(n), Space: O(n)
 */

public class Codec {

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private TreeNode deserializeHelper(ArrayDeque<String> arrayDeque) {
        String val = arrayDeque.poll();
        if (val.equals("null")) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        treeNode.left = deserializeHelper(arrayDeque);
        treeNode.right = deserializeHelper(arrayDeque);
        return treeNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>(Arrays.asList(data.split(",")));
        return deserializeHelper(arrayDeque);
    }
}