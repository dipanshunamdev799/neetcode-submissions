class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }
        int x = 0;
        res[x++] = pq.peek();
        pq.remove(nums[0]);
        for(int i=k; i<n; i++){
            pq.add(nums[i]);
            res[x++] = pq.peek();
            pq.remove(nums[i-k+1]);
        }
        return res;
    }
}
