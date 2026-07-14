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
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1val = 0;
        if(l1!=null){
            l1val = l1.val;
        } 
        int l2val = 0;
        if(l2!=null){
            l2val = l2.val;
        } 
        int sum = carry + l1val + l2val;
        carry = 0;
        if(sum==0){
            if(l1!=null || l2!=null) return new ListNode(0);
            else return null;
        }
        if(sum>=10) carry = 1;
        sum = sum%10;
        ListNode res = new ListNode(sum);
        if(l1!=null) l1 = l1.next;
        if(l2!=null) l2 = l2.next;
        res.next = addTwoNumbers(l1,l2);
        return res;
    }
}
