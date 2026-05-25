class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet() ){
             list.add(new int[] {entry.getValue(),entry.getKey()});
        }
        list.sort((a,b) -> a[0] - b[0]);
        for(int i=0; i<k; i++){
            ans[i] = list.get(list.size()-1-i)[1];
        }
        return ans;
    }
}
