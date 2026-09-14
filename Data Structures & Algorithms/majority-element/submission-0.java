class Solution {
    public int majorityElement(int[] nums) {
        int freq = 1;
        int el = nums[0];
        for(int i=1; i<nums.length; i++){
            if(el==nums[i]){
                freq++;
            }else{
                freq--;
            }
            if(freq==0){
                el = nums[i];
                freq = 1;
            }
        }
        return el;
    }
}