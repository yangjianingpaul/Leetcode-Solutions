import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Problem: 23. Merge k Sorted Lists
 * Difficulty: hard
 * Approach: LinkedList
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                minHeap.offer(listNode);
            }
        }

        ListNode head = new ListNode();
        ListNode currentNode = head;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            currentNode.next = smallest;
            currentNode = currentNode.next;
            smallest = smallest.next;
            if (smallest != null) {
                minHeap.offer(smallest);
            }
        }

        return head.next;
    }
}