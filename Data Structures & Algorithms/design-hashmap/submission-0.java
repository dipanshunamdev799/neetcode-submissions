class Node{
    int key;
    int value;
    Node next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    Node[] bucket;

    public MyHashMap() {
        bucket = new Node[1000];
    }
    
    public void put(int key, int value) {
        int index = key%1000;
        Node node = bucket[index];
        if(node==null){
            bucket[index] = new Node(key,value);
            return;
        }
        if(node.key==key){
            node.value = value;
            return;
        }
        Node prev = null;
        while(node!=null){
            prev = node;
            if(node.key==key){
                node.value = value;
                return;
            }
            node = node.next;
        }
        prev.next = new Node(key,value);
    }
    
    public int get(int key) {
        int index = key%1000;
        Node node = bucket[index];
        if(node==null) return -1;
        if(node.key==key) return node.value;
        while(node!=null){
            if(node.key==key) return node.value;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key%1000;
        Node node = bucket[index];
        if(node==null) return;
        if(node.key==key){
            bucket[index] = node.next;
            return;
        }
        Node prev = null;
        while(node!=null){
            if(node.key==key){
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */