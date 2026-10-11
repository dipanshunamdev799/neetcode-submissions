class Solution {
    record Pair(int freq,int el){};
    public int[] topKFrequent(int[] nums, int k) {
        Pair[] arr = new Pair[2001];
        for(int x: nums){
            int originalElement = x;
            if(x<0) x = Math.abs(x) + 1000;
            if(arr[x]==null){
                arr[x] = new Pair(1,originalElement);
            }else{
                arr[x] = new Pair(arr[x].freq()+1,originalElement);
            }
        }
        
        // Arrays.sort(arr,(a,b) -> b.freq() - a.freq() ); // reverse sort base on freq.
        Arrays.sort(arr, Comparator.nullsLast(
            (a,b) -> b.freq() - a.freq()
        ));

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = arr[i].el();
        }
        return res;
    }
}
