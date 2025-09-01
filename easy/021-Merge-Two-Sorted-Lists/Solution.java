/**
 * Problem: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode next = new ListNode(list2.val);
                current.next = next;
                current = next;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                ListNode next = new ListNode(list1.val);
                current.next = next;
                current = next;
                list1 = list1.next;
                continue;
            }

            if (list1.val < list2.val) {
                ListNode next = new ListNode(list1.val);
                current.next = next;
                current = next;
                list1 = list1.next;
            } else {
                ListNode next = new ListNode(list2.val);
                current.next = next;
                current = next;
                list2 = list2.next;
            }
        }
        return result.next;
    }
}