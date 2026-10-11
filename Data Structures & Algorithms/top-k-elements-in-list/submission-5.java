class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x: nums){
            mp.putIfAbsent(x,0);
            mp.put(x,mp.get(x)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0] );
        // min heap
        // poll removes min element
        // min freq KO
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
            if(pq.size()>k) pq.poll();
        }
        int[] res = new int[k];
        int x = 0;
        while(pq.size()!=0){
            res[x++] = pq.peek()[1];
            pq.poll();
        }
        return res;
    }
}
