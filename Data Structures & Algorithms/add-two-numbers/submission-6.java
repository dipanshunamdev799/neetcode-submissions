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

        if(l1==null && l2==null) return null;

        int num = 0;

        if(l1!=null){
            num+= l1.val;
            l1 = l1.next;
        }
        if(l2!=null){
            num+=l2.val;
            l2 = l2.next;
        }

        if(num<10){
            ListNode node = new ListNode(num);
            node.next = addTwoNumbers(l1,l2);
            return node;
        }

        int carry = 1;
        num = num%10;

        if(l1==null && l2==null){
            ListNode node = new ListNode(num);
            node.next = new ListNode(carry);
            return node;
        }

        if(l1!=null){
            l1.val = l1.val + 1;
        }else{
            l2.val = l2.val + 1;
        }

        ListNode res = new ListNode(num);
        res.next = addTwoNumbers(l1,l2);

        return res;
    }
}
