/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node curr = head;
        while(curr!=null){
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.random!=null)
            curr.next.random = curr.random.next;
            else
            curr.next.random = null;
            curr = curr.next.next;
        }
        curr = head;
        head = curr.next;
        Node tail;
        while(curr!=null){
            tail = curr.next;
            curr.next = curr.next.next;
            if(tail.next!=null)
            tail.next = tail.next.next;
            else
            tail.next = null;
            curr = curr.next;
        }
        return head;
    }
}
