class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count0 = 0;
        for(int x: nums){
            if(x==0) count0++;
            else product*=x;
        }
        if(count0>=2){
            for(int i=0; i<nums.length; i++) nums[i] = 0;
            return nums;
        }
        if(count0==1){
            for(int i=0; i<nums.length; i++) if(nums[i]==0) nums[i] = product; else nums[i] = 0;
            return nums;
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = product/nums[i];
        }
        return nums;
    }
}  
