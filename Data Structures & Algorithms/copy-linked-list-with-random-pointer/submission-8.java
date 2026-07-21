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
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        // copy nodes are there now

        temp = head;
        while(temp!=null){
            if(temp.random!=null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        // random pointers in place

        temp = head;
        Node res = temp.next;
        while(temp!=null){
            Node copy = temp.next;
            temp.next = copy.next;
            temp = copy.next;
            if(temp!=null) copy.next = temp.next; else copy.next = null;
        }
        return res;
    }
}
