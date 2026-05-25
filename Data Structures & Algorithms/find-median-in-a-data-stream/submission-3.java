class MedianFinder {

    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    int count = 0;

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        count++;

        //even data distribution : add element to right and then add smallest to left side
        //add the element to left ( doesn't matter if its the smallest )
        left.offer(num);
        //now from left get the smallest element add it to the right
        right.offer(left.poll());

        //handle uneven size :: since we are adding element to right, we need to give elements to left too
        if(right.size() > left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(count%2==0){
            return ( (double)right.peek() + left.peek() )/2;
        }else{
            return left.peek();
        }
    }
}