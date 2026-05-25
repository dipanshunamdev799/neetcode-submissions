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
        if(head==null) return head;
        ListNode tail = head;

        for(int i=0; i<k-1; i++){
            tail = tail.next;
            if(tail==null) return head;
        }

        ListNode temp = tail.next;
        tail.next = null;

        temp = reverseKGroup(temp,k);

        reverse(head);
        
        head.next = temp;

        return tail;

    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode res = reverse(head.next);

        head.next.next = head;

        return res;
    }
}
