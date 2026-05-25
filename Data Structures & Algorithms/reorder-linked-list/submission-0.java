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
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        while(reversed!=null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = reversed.next;

            head.next = reversed;
            reversed.next = tmp1;

            head = tmp1;
            reversed = tmp2;
        }
    }
    private ListNode reverse(ListNode node){
        if(node==null || node.next==null) return node;
        ListNode reversed = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return reversed;
    }
}
