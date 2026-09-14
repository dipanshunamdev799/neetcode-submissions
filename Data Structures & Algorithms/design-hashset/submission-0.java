class Node{
    int key;
    Node next;
    Node(int key){
        this.key = key;
        next = null;
    }
}

class MyHashSet {

    Node[] bucket;

    public MyHashSet() {
        bucket = new Node[1000];
    }
    
    public void add(int key) {
        int index = key % 1000;
        if(bucket[index]==null){
            bucket[index] = new Node(key);
            return;
        }
        Node node = bucket[index];
        if(node.key==key) return;
        while(node.next!=null){
            node = node.next;
            if(node.key==key) return;
        }
        node.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = key % 1000;
        Node node = bucket[index];
        if(node==null) return;
        if(node.key==key){
            bucket[index] = node.next;
            return;
        }
        Node prev = null;
        while(node!=null || node.key!=key){
            prev = node;
            node = node.next;
        }
        if(node==null) return;
        prev.next = node.next;
    }
    
    public boolean contains(int key) {
        int index = key%1000;
        Node node = bucket[index];
        while(node!=null){
            if(node.key==key) return true;
            node = node.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */