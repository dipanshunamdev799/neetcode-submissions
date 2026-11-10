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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow is at mid.
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverseList(l2);

        while(l2!=null){
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = temp;
            l1 = temp;
        }
    }

    private ListNode reverseList(ListNode head){
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode res = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return res;
    }
}
