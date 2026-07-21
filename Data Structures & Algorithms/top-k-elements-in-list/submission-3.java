class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int temp = 0;
        Arrays.sort(nums);
        int i = nums.length-1;
        int n = nums.length;
        while(temp<k && i>=0){
            int x = nums[i];
            while(i-1>=0 && nums[i-1]==x){
                i--;
            }
            i--;
            res[temp++] = x;
        }
        return res;
    }
}
