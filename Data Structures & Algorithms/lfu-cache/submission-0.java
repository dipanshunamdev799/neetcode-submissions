class ListNode{
    int freq;
    int key;
    int val;
    ListNode left;
    ListNode right;
    ListNode(int key,int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}
class DoublyLinkedList{
    private ListNode head;
    private ListNode tail;
    public int size=0;

    public void add(ListNode node){  // add to head
        if(node==null) return;
        size++;
        if(head==null){
            head = node;
            tail = node;
            return;
        }
        head.right = node;
        node.left = head;
        head = head.right;
    }
    public ListNode remove(){   // remove from tail
        if(head==null) return null;
        ListNode node = tail;
        size--;
        tail = tail.right;
        if(tail==null){
            head = null;
            tail = null;
            return node;
        }
        tail.left = null;
        node.right = null;
        return node;
    }

    public ListNode remove(ListNode node){
        if(node==null) return node;
        if(node==head) head = head.left;
        if(node==tail) tail = tail.right;
        size--;
        if(size==0){
            head=null;
            tail=null;
        }
        ListNode left = node.left;
        ListNode right = node.right;
        if(left!=null){
            node.left.right = node.right;
        }
        if(right!=null){
            node.right.left = node.left;
        }
        node.left = null;
        node.right = null;
        return node;
    }
}
class LFUCache {

    HashMap<Integer,ListNode> nodeMap;  // key -> node
    HashMap<Integer,DoublyLinkedList> freqMap;  // freq -> doubly ll head
    int MAX;
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.MAX = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            ListNode node = nodeMap.get(key);
            int res = node.val;
            int freq = node.freq;
            if(freq==minFreq && freqMap.get(freq).size==1){
                minFreq++;
            }
            freqMap.get(freq).remove(node);
            if(freqMap.get(freq).size==0){
                freqMap.remove(freq);
            }
            node.freq++;
            DoublyLinkedList dll = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
            dll.add(node);
            freqMap.put(node.freq,dll);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            ListNode node = nodeMap.get(key);
            node.val = value;
            int freq = node.freq;
            if(freq==minFreq && freqMap.get(freq).size==1){
                minFreq++;
            }
            freqMap.get(node.freq).remove(node);
            if(freqMap.get(freq).size==0){
                freqMap.remove(freq);
            }
            node.freq++;
            DoublyLinkedList dll = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
            dll.add(node);
            freqMap.put(node.freq,dll);
            return;
        }
        if(nodeMap.size()!=MAX){
            ListNode node = new ListNode(key,value);
            DoublyLinkedList dll = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
            dll.add(node);
            freqMap.put(node.freq,dll);
            nodeMap.put(key,node);
            minFreq = 1;
            return;
        }
        // nodeMap.size() == max and not found in nodeMap -> deletion needed
        ListNode toRemove = freqMap.get(minFreq).remove();  // remove lru
        nodeMap.remove(toRemove.key);
        if(freqMap.get(minFreq).size==0){
            freqMap.remove(minFreq);
        }
        ListNode node = new ListNode(key,value);
        DoublyLinkedList dll = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
        dll.add(node);
        freqMap.put(node.freq,dll);
        nodeMap.put(key,node);
        minFreq = 1;
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

