/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /**
 * Problem: 25. Reverse Nodes in k-Group
 * Difficulty: hard
 * Approach: LinkedList
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int index = k;
        ListNode indexNode = head;
        while (index > 0) {
            if (indexNode != null) {
                indexNode = indexNode.next;
                index--;
            } else {
                return head;
            }
        }

        ListNode lastHead = reverseKGroup(indexNode, k);

        while (k > 0) {
            ListNode next = head.next;
            head.next = lastHead;
            lastHead = head;
            head = next;
            k--;
        }

        return lastHead;
    }
}