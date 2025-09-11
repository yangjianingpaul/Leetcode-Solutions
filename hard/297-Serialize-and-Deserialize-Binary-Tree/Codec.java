
/**
 * Problem: 297. Serialize and Deserialize Binary Tree
 * Difficulty: hard
 * Approach: dfs
 * Time: O(n), Space: O(n)
 */

public class Codec {
    ArrayList<String> arrayList;

    public void dfsSerialize(TreeNode node, int layer) {
        if (arrayList.size() == layer) {
            if (node == null) {
                arrayList.add("null");
                return;
            } else {
                arrayList.add(node.val + "");
                layer++;
                dfsSerialize(node.left, layer);
                dfsSerialize(node.right, layer);
            }
        } else {
            String string = arrayList.get(layer);
            if (node == null) {
                string = string + "," + "null";
                arrayList.set(layer, string);
                return;
            } else {
                string = string + "," + node.val;
                arrayList.set(layer, string);
                layer++;
                dfsSerialize(node.left, layer);
                dfsSerialize(node.right, layer);
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        arrayList = new ArrayList<String>();
        String result = "";
        dfsSerialize(root, 0);

        for (String string : arrayList) {
            if (result.length() == 0) {
                result = string;
            } else {
                result = result + "," + string;
            }
        }
        return result;
    }

    public List<TreeNode> dfsDeserialize(String[] data, int index) {
        ArrayList<TreeNode> currentLayer = new ArrayList<TreeNode>();
        if (index >= data.length) {
            for (String str : data) {
                if (str.equals("null")) {
                    currentLayer.add(null);
                } else {
                    TreeNode treeNode = new TreeNode(Integer.parseInt(str));
                    currentLayer.add(treeNode);
                }
            }
            return currentLayer;
        }

        int nextIndex = 0;
        for (int i = 0; i < index; i++) {
            if (!data[i].equals("null")) {
                nextIndex++;
            }
        }

        String[] nextLayer = Arrays.copyOfRange(data, index, data.length);
        List<TreeNode> nextLayerList = dfsDeserialize(nextLayer, nextIndex * 2);
        int j = 0;
        for (int i = 0; i < index; i++) {
            if (data[i].equals("null")) {
                currentLayer.add(null);
            } else {
                TreeNode treeNode = new TreeNode(Integer.parseInt(data[i]));
                if (j < nextLayerList.size()) {
                    treeNode.left = nextLayerList.get(j);
                    j++;
                }

                if (j < nextLayerList.size()) {
                    treeNode.right = nextLayerList.get(j);
                    j++;
                }
                currentLayer.add(treeNode);
            }
        }

        return currentLayer;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] strs = data.split(",");
        return dfsDeserialize(strs, 1).get(0);
    }
}