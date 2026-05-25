class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> temp[] = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(temp[entry.getValue()]==null){
                temp[entry.getValue()] = new ArrayList<>();
            }
            temp[entry.getValue()].add(entry.getKey());
        }
        for(int i=temp.length-1; i>=0 && k!=0; i--){
            if(temp[i]==null) continue;
            List<Integer> list = temp[i];
            for(int j=0; j<list.size() && k!=0; j++){
                ans[--k] = list.get(j);
            }
        }
        return ans;
    }
}
