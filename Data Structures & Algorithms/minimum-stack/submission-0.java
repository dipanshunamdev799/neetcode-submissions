class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class MinStack {

    ListNode head;
    ListNode tail;
    PriorityQueue<Integer> pq;


    public MinStack() {
        head = null;
        tail = null;
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        if(head==null){
            head = new ListNode(val);
            tail = head;
        }else{
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
        }
        pq.add(val);
    }
    
    public void pop() {
        int val = head.val;
        head = head.next;
        pq.remove(val);
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return pq.peek();
    }
}
