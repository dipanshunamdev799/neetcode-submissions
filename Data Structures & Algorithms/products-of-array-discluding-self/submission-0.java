class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count0 = 0;
        int index0 = 0;
        int product = 1;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num==0){
                index0 = i;
                count0++;
            }else{
                product*=num;
            }
        }
        if(count0==0){
            for(int i=0; i<nums.length; i++){
                nums[i] = product/nums[i];
            }
            return nums;
        }else if(count0==1){
            for(int i=0; i<nums.length; i++) nums[i] = 0;
            nums[index0] = product;
            return nums;
        }else{
            for(int i=0; i<nums.length; i++) nums[i] = 0;
            return nums;
        }
    }
}  
