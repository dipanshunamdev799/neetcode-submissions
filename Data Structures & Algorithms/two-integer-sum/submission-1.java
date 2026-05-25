class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(mp.containsKey(x)){
                ans[0] = mp.get(x);
                ans[1] = i;
                return ans;
            }
            mp.put(target-nums[i],i);
        }
        return ans;
    }
}
