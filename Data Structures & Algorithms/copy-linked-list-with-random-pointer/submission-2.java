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
        Node curr = head;
        while(curr!=null){
            Node copy;
            Node temp;
            // handle copy of original
            if(mp.containsKey(curr)){
                copy = mp.get(curr);
            }else{
                copy = new Node(curr.val);
                mp.put(curr,copy);
            }
            // handle next
            if(mp.containsKey(curr.next)){
                copy.next = mp.get(curr.next);
            }else{
                temp = null;
                if(curr.next!=null){
                    temp = new Node(curr.next.val);
                }
                copy.next = temp;
                mp.put(curr.next,copy.next);
            }
            // handle random
            if(mp.containsKey(curr.random)){
                copy.random = mp.get(curr.random);
            }else{
                temp = null;
                if(curr.random!=null){
                    temp = new Node(curr.random.val);
                }
                copy.random = temp;
                mp.put(curr.random,copy.random);
            }
            curr = curr.next;
        }
        return mp.get(head);
    }
}
