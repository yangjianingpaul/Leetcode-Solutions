package 61. Rotate List;

public class rotateRight {
    
}


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
 * Problem: 61. Rotate List
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode index=head;
        int length=1;
        while(index.next!=null){
            length++;
            index=index.next;
        }

        k%=length;

        int times=length-k;
        index.next=head;
        for(int i=0;i<times;i++){
            index=index.next;
        }

        head=index.next;
        index.next=null;
        return head;
    }
}