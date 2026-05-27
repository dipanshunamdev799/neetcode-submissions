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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while(l1!=null || l2!=null){
            int sum = 0;
            if(l1!=null){
                sum+= l1.val;
                l1 = l1.next;
            } 
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            } 
            sum+=carry;
            carry = 0;
            // if(sum==0) break;
            if(head==null){
                head = new ListNode(sum%10);
                tail = head;
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum>=10 ? 1 : 0;
        }
        if(carry!=0) tail.next = new ListNode(1);
        return head;
    }
}
