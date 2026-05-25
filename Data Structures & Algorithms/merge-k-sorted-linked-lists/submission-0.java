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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node!=null)
            pq.offer(node);
        }
        ListNode head = null;
        ListNode tail = null;
        while(!pq.isEmpty()){
            if(head==null){
                head = pq.poll();
                tail = head;
                ListNode tmp = head.next;
                head.next = null;
                if(tmp!=null)
                pq.offer(tmp);
            }else{
                ListNode top = pq.poll();
                ListNode next = top.next;
                top.next = null;

                tail.next = top;
                tail = tail.next;

                if(next!=null)
                pq.offer(next);
            }
        }
        return head;
    }
}
