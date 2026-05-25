class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0 ;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num: nums){
            if(!mp.containsKey(num)){
                int left = mp.getOrDefault(num-1,0);
                int right = mp.getOrDefault(num+1,0);
                int len = left + right + 1;

                mp.put(num,len);
                mp.put(num-left,len);
                mp.put(num+right,len);
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
