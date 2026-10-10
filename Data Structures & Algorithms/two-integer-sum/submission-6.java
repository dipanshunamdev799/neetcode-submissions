class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(mp.containsKey(x)){
                return new int[]{mp.get(x),i};
            }
            mp.put(target-x,i);
        }
        return new int[]{};
    }
}
