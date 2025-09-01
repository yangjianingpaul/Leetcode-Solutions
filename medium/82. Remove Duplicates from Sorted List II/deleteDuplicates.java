package 82. Remove Duplicates from Sorted List II;

public class deleteDuplicates {
    
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
 * Problem: 82. Remove Duplicates from Sorted List II
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHaed=new ListNode();
        ListNode index=newHaed;
        ListNode cur=head;
        ListNode next=cur.next;

        while(next!=null){
            if(cur.val!=next.val){
                if(cur.next==next){
                    ListNode nextIndex=new ListNode();
                    index.next=nextIndex;
                    index=index.next;
                    index.val=cur.val;
                }

                cur=next;
            }

            next=next.next;
        }

        if(cur.next==null){
            ListNode nextIndex=new ListNode();
            index.next=nextIndex;
            index=index.next;
            index.val=cur.val;
        }

        return newHaed.next;
    }
}