
/**
 * Problem: 208. Implement Trie (Prefix Tree)
 * Difficulty: Medium
 * Approach: Prefix Tree
 * Time: O(n), Space: O(n)
 */

class Trie {

    public class Node {
        boolean isEnd;
        Node[] nextChar = new Node[26];
    }

    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node current = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.nextChar[index] != null) {
                current = current.nextChar[index];
            } else {
                Node newNode = new Node();
                current.nextChar[index] = newNode;
                current = newNode;
            }
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.nextChar[index] != null) {
                current = current.nextChar[index];
            } else {
                return false;
            }
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = head;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.nextChar[index] != null) {
                current = current.nextChar[index];
            } else {
                return false;
            }
        }

        return true;
    }
}