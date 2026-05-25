class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int el = nums[i];
            if(hashMap.containsKey(target-el)){
                ans[0] = hashMap.get(target-el);
                ans[1] = i;
                return ans;
            }else{
                hashMap.put(el,i);
            }
        }
        return ans;
    }
}
