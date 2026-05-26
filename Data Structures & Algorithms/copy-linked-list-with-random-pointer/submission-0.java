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
    private HashMap<Node,Node> mp = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node node = new Node(head.val);
        mp.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = mp.get(head.random);
        return node;
    }
}
