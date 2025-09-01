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
 * Problem: 86. Partition List
 * Difficulty: Medium
 * Approach: Linked List
 * Time: O(n), Space: O(n)
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> less=new ArrayList<>();
        ArrayList<Integer> more=new ArrayList<>();

        while(head!=null){
            if(head.val<x){
                less.add(head.val);
            } else {
                more.add(head.val);
            }

            head=head.next;
        }

        ListNode newHead=new ListNode();
        ListNode index=newHead;

        for(int i=0;i<less.size();i++){
            ListNode next=new ListNode();
            index.next=next;
            index=index.next;
            index.val=less.get(i);
        }

        for(int i=0;i<more.size();i++){
            ListNode next=new ListNode();
            index.next=next;
            index=index.next;
            index.val=more.get(i);
        }

        return newHead.next;
    }
}