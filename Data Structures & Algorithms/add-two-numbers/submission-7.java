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
        ListNode tail = null;
        ListNode head = null;

        int carry = 0;

        while(!(l1==null && l2==null)){

            int sum = 0;

            if(l1!=null){
                sum+= l1.val;
                l1 = l1.next;
            } 

            if(l2!=null){
                sum+= l2.val;
                l2 = l2.next;
            } 

            sum+= carry;
            carry = 0;

            if(sum>=10) carry = 1;

            sum = sum%10;

            if(tail==null){
                tail = new ListNode(sum);
                head = tail;
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

        }

        if(carry==1){
            tail.next = new ListNode(1);
        }

        return head;
    }
}
