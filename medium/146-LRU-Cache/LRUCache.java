/**
 * Problem: 146. LRU Cache
 * Difficulty: Medium
 * Approach: DLL + Map
 * Time: O(n), Space: O(n)
 */

class LRUCache {

    class DoubleLink {
        int key;
        int value;

        DoubleLink nextNode;
        DoubleLink preNode;

        DoubleLink(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    // ArrayList<Integer> cache;
    // HashMap<Integer, Integer> hashMap;

    HashMap<Integer, DoubleLink> hashMap;
    DoubleLink head;
    DoubleLink end;

    public void insertNode(DoubleLink node, DoubleLink aimNode) {
        node.nextNode = aimNode.nextNode;
        aimNode.nextNode.preNode = node;
        aimNode.nextNode = node;
        node.preNode = aimNode;
        return;
    }

    public void deleteNode(DoubleLink node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
        return;
    }

    public LRUCache(int capacity) {
        cache = new ArrayList<Integer>();
        // hashMap = new HashMap<Integer, Integer>();
        hashMap = new HashMap<Integer, DoubleLink>();
        head = new DoubleLink(-1, -1);
        end = new DoubleLink(-1, -1);

        head.nextNode = end;
        head.preNode = null;
        end.preNode = head;
        end.nextNode = null;
        size = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            DoubleLink node = hashMap.get(key);
            deleteNode(node);
            insertNode(node, head);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            DoubleLink node = hashMap.get(key);
            deleteNode(node);
        }

        DoubleLink newNode = new DoubleLink(key, value);
        insertNode(newNode, head);
        hashMap.put(key, newNode);

        if (hashMap.size() > size) {
            DoubleLink lastNode = end.preNode;
            hashMap.remove(lastNode.key);
            deleteNode(lastNode);
        }
    }
}
