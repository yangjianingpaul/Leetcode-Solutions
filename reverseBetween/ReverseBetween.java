package reverseBetween;

import reverseBetween.Solution.ListNode;

public class ReverseBetween {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode reverseBetween = solution.reverseBetween(null, 0, 0);
        System.out.println(reverseBetween);
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

    public ListNode reverse(ListNode head, int length) {
        ListNode currentNode = head;
        ListNode lastNode = null;
        ListNode nextNode = currentNode.next;

        while (length > 0) {
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
            length--;
        }

        head.next = currentNode;
        return lastNode;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode index = head;
        ListNode front = head;
        while (left - 1 > 0) {
            front = index;
            index = index.next;
            left--;
        }

        int length = right - left;
        ListNode reverse = reverse(index, length);
        if (index != head) {
            front.next = reverse;
            return head;
        } else {
            return reverse;
        }
    }
}