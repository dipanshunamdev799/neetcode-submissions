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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode originalHead = head;
        int x = left;
        ListNode prev = null;
        ListNode start = null;
        ListNode curr = head;
        while(x!=0 && curr!=null){
            start = prev;
            prev = curr;
            curr = curr.next;
            x--;
        }
        ListNode tail = prev;
        x = right - left;
        while(x!=0 && curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            x--;
        }
        head = prev;
        tail.next = curr;
        if(start==null){
            return head;
        }else{
            start.next = head;
            return originalHead;
        }
    }
}