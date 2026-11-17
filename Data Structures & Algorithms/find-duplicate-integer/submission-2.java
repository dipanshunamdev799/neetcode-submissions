class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num==i+1){
                nums[i] = -1;
                continue;
            }

            int el = nums[num-1]; // el at num pos
            if(el==-1) return num;

            // val swap
            nums[num-1] = nums[i];
            nums[i] = el;
            i--;
        }
        return -1;
    }
}
