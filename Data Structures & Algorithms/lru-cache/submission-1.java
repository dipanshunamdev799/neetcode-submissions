class ListNode{
    int val;
    int key;
    ListNode prev;
    ListNode next;
    ListNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int MAX;
    ListNode head;  // most recently used
    ListNode tail;
    HashMap<Integer,ListNode> mp;


    public LRUCache(int capacity) {
        this.MAX = capacity;
        mp = new HashMap<>();
    }
    
    public int get(int key) {
        if(mp.size()==0) return -1;
        if(mp.containsKey(key)){
            pushToHead(mp.get(key));
            return mp.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            mp.get(key).val = value;
            pushToHead(mp.get(key));
        }else{
            if(mp.size()==MAX){
                // remove LRU form ll and map
                mp.remove(tail.key);
                tail = tail.next;
                if(tail!=null)
                tail.prev = null;
            }
            // add the node to head
            ListNode node = new ListNode(key,value);
            mp.put(key,node);
            if(head==null){
                head = node;
                tail = node;
                return;
            }
            head.next = node;
            node.prev = head;
            head = head.next;
        }
    }

    private void pushToHead(ListNode node){
        ListNode before = node.prev;
        ListNode after = node.next;
        //only one element in the map
        if(before==null && after==null) return;
        // node at the tail
        if(before==null){
            tail = tail.next;
            node.next.prev = null;
            node.next = null;
            head.next = node;
            node.prev = head;
            head = head.next;
            return;
        }
        // already at head
        if(after==null) return;
        before.next = after;
        after.prev = before;
        node.next = null;
        node.prev = null;
        head.next = node;
        node.prev = head;
        head = head.next;
    }
}
