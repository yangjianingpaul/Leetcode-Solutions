package sortList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import sortList.Solution.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode sortList = solution.sortList(null);
    }
}

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

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode listNode = head;
        while (listNode != null) {
            arrayList.add(listNode.val);
        }

        Collections.sort(arrayList);

        head.val = arrayList.get(0);
        ListNode index = head;
        for (int i = 1; i < arrayList.size(); i++) {
            ListNode next = new ListNode();
            next.val = arrayList.get(i);
            index.next = next;
            index = next;
        }

        return head;
    }
}