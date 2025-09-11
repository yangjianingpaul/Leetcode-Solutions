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
        ListNode result = new ListNode();
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode index = result;
        boolean flag = true;

        while (flag) {
            int nonNullNum = 0;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    nonNullNum++;
                    if (lists[i].val < min) {
                        minIndex = i;
                        min = lists[i].val;
                    }
                }
            }

            if (nonNullNum == 0) {
                return result.next;
            } else if (nonNullNum == 1) {
                index.next = lists[minIndex];
                return result.next;
            } else {
                ListNode listNode = new ListNode();
                listNode.val = min;
                index.next = listNode;
                index = listNode;
                lists[minIndex] = lists[minIndex].next;
            }
        }

        return result.next;
    }
}