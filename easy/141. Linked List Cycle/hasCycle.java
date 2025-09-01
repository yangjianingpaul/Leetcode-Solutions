package 141. Linked List Cycle;

public class hasCycle {
    
}

/**
 * Problem: 141. Linked List Cycle
 * Difficulty: Easy
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (slow.next != null && fast.next!=null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}