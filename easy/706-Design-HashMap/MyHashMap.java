
/**
 * Problem: 706. Design HashMap
 * Difficulty: Easy
 * Approach: HashMap
 * Time: O(n), Space: O(n)
 */

class MyHashMap {
    public class Pair {

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    ArrayList<LinkedList<Pair>> data;

    public MyHashMap() {
        data = new ArrayList<LinkedList<Pair>>();
        for (int i = 0; i < 1000; i++) {
            data.add(new LinkedList<Pair>());
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> linkedList = data.get(hash);
        for (Pair pair : linkedList) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }

        Pair pair = new Pair(key, value);
        linkedList.addLast(pair);
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Pair> linkedList = data.get(hash);
        for (Pair pair : linkedList) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Pair> linkedList = data.get(hash);
        for (Pair pair : linkedList) {
            if (pair.getKey() == key) {
                linkedList.remove(pair);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % 1000;
    }
}