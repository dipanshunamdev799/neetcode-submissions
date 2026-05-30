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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head; 
        if(head==null) return head;   
        ListNode tail = head;
        for(int i=0; i<k-1; i++){
            tail = tail.next;
            if(tail==null) return head;
            // return the node if can't make k-1 jumps
            // or if you are at null after k-1 jumps
            // as the tail doesn't exist for the reversal
        }
        ListNode temp = tail.next;
        tail.next = null;

        // reversal code
        ListNode prev = null;
        // we have head
        ListNode curr = head;
        while(curr!=null){
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        // now head and tail are reversed

        head.next = reverseKGroup(temp,k);
        
        return tail;
    }
}
