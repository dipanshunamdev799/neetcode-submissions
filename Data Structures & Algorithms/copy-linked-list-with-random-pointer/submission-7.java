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
        if(head==null) return null;
        HashMap<Node,Node> mp = new HashMap<>();
        Node tail = null;
        Node copyHead = null;
        while(head!=null){
            Node copy;
            if(mp.containsKey(head)){
                copy = mp.get(head);
            }else{
                copy = new Node(head.val);
                mp.put(head,copy);
            }
            Node random;
            if(mp.containsKey(head.random)){
                random = mp.get(head.random);
            }else{
                if(head.random!=null)
                random = new Node(head.random.val);
                else random = null;
                mp.put(head.random,random);
            }
            if(copyHead==null) copyHead = copy;
            if(tail==null){
                tail = copy;
            }else{
                tail.next = copy;
                tail = tail.next;
            }
            copy.random = random;
            head = head.next;
        }
        return copyHead;
    }
}
