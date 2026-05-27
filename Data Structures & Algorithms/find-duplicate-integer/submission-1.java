class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==-1) continue;
            int num = nums[i];
            if(nums[num-1]==-1) return num;
            nums[i] = nums[num-1];
            nums[num-1] = -1;
            i--;
        }
        return -1;
    }
}
