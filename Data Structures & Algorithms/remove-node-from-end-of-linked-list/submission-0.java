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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        ListNode tmp = head;
        ListNode prev = null;
        int jumps = size - n;
        for(int i=0; i<jumps; i++){
            prev = tmp;
            tmp = tmp.next;
        }
        if(prev==null){
            return tmp.next;
        }
        prev.next = tmp.next;
        return head;
    }
    private int getSize(ListNode node){
        if(node==null) return 0;
        return 1 + getSize(node.next);
    }
}
