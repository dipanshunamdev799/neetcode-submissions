class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(val==nums[i]){
                continue;
            }
            nums[len++] = nums[i];
        }
        return len;
    }
}