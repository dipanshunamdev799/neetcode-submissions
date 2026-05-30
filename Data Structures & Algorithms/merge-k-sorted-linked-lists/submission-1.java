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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val
        );
        for(ListNode list: lists){
            if(list!=null) pq.add(list);
        }
        if(pq.size()==0) return null;
        ListNode head = pq.poll();
        if(head.next!=null) pq.add(head.next);
        head.next = null;
        ListNode tail = head;
        while(pq.size()!=0){
            ListNode node = pq.poll();
            if(node.next!=null) pq.add(node.next);
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }
}
