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
        Node res = new Node(head.val);
        mp.put(head,res);
        Node temp = res;
        head = head.next;
        while(head!=null){
            Node node;
            if(mp.containsKey(head)){
                node = mp.get(head);
            }else{
                node = new Node(head.val);
                mp.put(head,node);
            }

            temp.next = node;
            Node random;
            
            if(mp.containsKey(head.random)){
                random = mp.get(head.random);
            }else{
                if(head.random!=null)
                random = new Node(head.random.val);
                else random = null;
                mp.put(head.random,random);
            }
            node.random = random;
            temp = temp.next;
            head = head.next;
        }
        return res;
    }
}
