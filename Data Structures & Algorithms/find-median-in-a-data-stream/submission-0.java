class MedianFinder {

    Heap heap;
    double sum;
    int count;

    public MedianFinder() {
        heap = new Heap();
        sum =  0;
        count = 0;
    }
    
    public void addNum(int num) {
        heap.add(num);
        sum+= num;
        count++;
    }
    
    public double findMedian() {
        if(count%2==0){
            return sum/count;
        }else{
            return heap.arr.get(heap.getSize()/2);
        }
    }
}
class Heap{
    List<Integer> arr;
    Heap(){
        arr = new ArrayList<>();
    }
    private void heapify(int i){
        int largest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int n = arr.size();

        if(leftChild < n && arr.get(leftChild) > arr.get(largest) ) largest = leftChild;
        if(rightChild < n && arr.get(rightChild) > arr.get(largest) ) largest = rightChild;

        if(largest!=i){
            Collections.swap(arr,largest,i);
            heapify(largest);
        }
    }
    public void add(int x){
        arr.add(x);
        heapify(arr.size()-1);
    }
    public int get(int i){
        if(i<0 || i>=arr.size()) return -1;
        return arr.get(i);
    }
    public int getSize(){
        return arr.size();
    }
}