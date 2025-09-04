/**
 * Problem: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

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
class Solution {
    ListNode result = new ListNode();
    ListNode index = result;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            index.next = list2;
            return result.next;
        }

        if (list2 == null) {
            index.next = list1;
            return result.next;
        }

        ListNode addNode = new ListNode();
        if (list1.val <= list2.val) {
            addNode.val = list1.val;
            index.next = addNode;
            index = addNode;
            list1 = list1.next;
        } else {
            addNode.val = list2.val;
            index.next = addNode;
            index = addNode;
            list2 = list2.next;
        }

        ListNode mergeTwoLists = mergeTwoLists(list1, list2);
        return mergeTwoLists;
    }
}