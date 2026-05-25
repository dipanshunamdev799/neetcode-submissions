/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> newNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return node;

        if(newNodes.containsKey(node)) return newNodes.get(node);

        if(node.neighbors.size()==0){
            Node newNode = new Node(node.val);
            newNodes.put(node,newNode);
            return newNode;
        }

        Node newNode = new Node(node.val);
        newNodes.put(node,newNode);

        for(Node x: node.neighbors){
            Node tmp = cloneGraph(x);
            newNode.neighbors.add(tmp);
        }
        
        return newNode;
    }
}