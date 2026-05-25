class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Pair> list = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.putIfAbsent(num,0);
            mp.put(num,mp.get(num)+1);
        }
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(list,(a,b)->b.freq-a.freq);
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = list.get(i).val;
        }    
        return res;    
    }
}
class Pair{
    int freq = 0;
    int val = 0;
    Pair(int val,int freq){
        this.val = val;
        this.freq = freq;
    }
}