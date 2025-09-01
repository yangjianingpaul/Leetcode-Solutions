package 92. Reverse Linked List II;

public class reverseBetween {
    
}

/**
 * Problem: 92. Reverse Linked List II
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode index = head;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= right; i++) {
            if (i < left) {
                ListNode nextNode = new ListNode(index.val);
                current.next = nextNode;
                current = nextNode;
            } else if (i >= left) {
                arrayList.add(0, index.val);
            }
            index = index.next;
        }

        for (Integer integer : arrayList) {
            ListNode nextNode = new ListNode(integer);
            current.next = nextNode;
            current = nextNode;
        }

        current.next = index;
        return result.next;
    }
}