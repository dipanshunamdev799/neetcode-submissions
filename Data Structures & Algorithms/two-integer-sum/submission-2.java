class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(target-nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i]) && i != mp.get(nums[i])){
                return new int[]{i,mp.get(nums[i])};
            }
        }
        return new int[]{};
    }
}
