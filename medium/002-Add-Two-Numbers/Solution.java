/**
 * Problem: 2. Add Two Numbers
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextBit = 0;
        ListNode result = new ListNode();
        ListNode index = result;
        ListNode lastIndex = index;
        while (l1 != null || l2 != null) {
            int sum = nextBit;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            nextBit = sum / 10;
            sum %= 10;
            index.val = sum;
            ListNode nextIndex = new ListNode();
            index.next = nextIndex;
            lastIndex = index;
            index = nextIndex;
        }

        if (nextBit == 0) {
            lastIndex.next = null;
        } else {
            index.val = nextBit;
        }
        return result;
    }
}