class LinkedList {
    LinkedList next;
    int value;
    LinkedList(int x){
        this.value = x;
    }
}

class MyCircularQueue {

    int size = 0;
    LinkedList head = null;
    int MAX = 0;

    public MyCircularQueue(int k) {
        this.MAX = k;
        this.size = 0;
        head = null;        
    }
    
    public boolean enQueue(int value) {

        if(size==MAX) return false;

        if(head==null){
            head = new LinkedList(value);
            head.next = head;
            size++;
            return true;
        }

        LinkedList node = new LinkedList(value);
        node.next = head.next;
        head.next = node;
        head = node;
        size++;
        return true;
        
    }
    
    public boolean deQueue() {

        if(size==0) return false;

        if(size==1){
            head = null;
            size--;
            return true;
        }

        LinkedList delete = head.next;
        head.next = delete.next;
        delete.next = null;
        size--;
        return true;
        
    }
    
    public int Front() {

        if(size==0) return -1;
        return head.next.value;
        
    }
    
    public int Rear() {

        if(size==0) return -1;
        return head.value;
        
    }
    
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
        
    }
    
    public boolean isFull() {
        if(size==MAX) return true;
        return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */