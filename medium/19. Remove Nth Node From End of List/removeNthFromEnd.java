package 19. Remove Nth Node From End of List;

public class removeNthFromEnd {
    
}

/**
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        ListNode current = head;
        while (current != null) {
            index++;
            current = current.next;
        }

        int times = index - n - 1;
        if (times < 0) {
            return head.next;
        }

        current = head;
        while (times > 0) {
            current = current.next;
            times--;
        }

        current.next = current.next.next;
        return head;
    }
}