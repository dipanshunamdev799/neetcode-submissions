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
        ArrayList<ListNode> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head);
            head = head.next;
        }
        int len = arr.size();
        int i = 0;
        int j = len-1;

        while(i<j){
            arr.get(i).next = arr.get(j);
            arr.get(j).next = arr.get(i+1);
            i++;
            j--;
        }
        arr.get(i).next = null;
        
        // return arr.get(0);
    }
}
