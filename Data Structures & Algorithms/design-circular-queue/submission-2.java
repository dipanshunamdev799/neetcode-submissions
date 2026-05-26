class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class MyCircularQueue {

    int MAX = 0;
    int size;
    ListNode front; // will be head of the linked list
    ListNode rear; // will be tail of the linked list


    public MyCircularQueue(int k) {
        this.MAX = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if(this.size==MAX) return false;
        if(size==0){ 
            front = new ListNode(value);
            front.next = front;
            rear = front;
        }else{
            ListNode temp = new ListNode(value);
            rear.next = temp;
            temp.next = front;
            rear = temp;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(this.size==0) return false;
        size--;
        ListNode temp = front;
        rear.next = front.next;
        front = front.next;
        temp.next = null;
        return true;
    }
    
    public int Front() {
        if(size==0) return -1;
        return front.val;
    }
    
    public int Rear() {
        if(size==0) return -1;
        return rear.val;
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