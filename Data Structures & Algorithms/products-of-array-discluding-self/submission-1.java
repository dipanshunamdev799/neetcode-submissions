class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count0 = 0;
        int n = nums.length;
        int prod = 1;
        int idx = -1;
        for(int i=0; i<n; i++){
            int x= nums[i];
            if(x==0){
                idx = i;
                count0++;
            }else{
                prod= prod*x;
            }
        } 
        if(count0>1) return new int[n];
        if(count0==1){
            int[] res = new int[n];
            res[idx] = prod;
            return res;
        }
        for(int i=0; i<n; i++){
            nums[i] = prod/nums[i];
        }
        return nums;
    }
}  
