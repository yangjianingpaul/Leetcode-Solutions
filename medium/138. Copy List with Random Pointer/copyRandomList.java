package 138. Copy List with Random Pointer;

public class copyRandomList {
    
}

/**
 * Problem: 138. Copy List with Random Pointer
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public Node copyRandomList(Node head) {
        Node result = new Node(0);
        Node newCurrent = result;
        Node current = head;

        while (current != null) {
            Node nextNode = new Node(current.val);
            newCurrent.next = nextNode;
            newCurrent = nextNode;
            current = current.next;
        }

        current = head;
        newCurrent = result.next;

        while (current != null) {
            Node randomNode = head;
            Node newRandomNode = result.next;

            while (current.random != randomNode) {
                randomNode = randomNode.next;
                newRandomNode = newRandomNode.next;
            }

            newCurrent.random = newRandomNode;
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return result.next;
    }
}