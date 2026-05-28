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
        if(head==null) return;
        do{
            if(fast.next==null){
                // odd len
                break;
            }
            if(fast.next.next==null){
                //even len
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while(true);
        // now slow is at mid
        ListNode temp = slow.next;
        slow.next = null;
        temp = reverse(temp);
        // now merget tameeee
        // size of temp will always be smaller or equal
        while(temp!=null){
            ListNode node = temp;
            temp = temp.next;
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }
    private ListNode reverse(ListNode head){
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
