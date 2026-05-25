class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int count = 0;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        count++;
        max.offer(num);
        min.offer(max.poll());
        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(count%2==0){
            return ( (double)min.peek() + max.peek() )/2;
        }else{
            return max.peek();
        }
    }
}