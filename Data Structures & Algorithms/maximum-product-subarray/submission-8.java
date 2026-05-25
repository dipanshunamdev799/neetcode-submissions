class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        for(int num: nums) res = Math.max(res,num);
        
        int currMax = 1;
        int currMin = 1;

        for (int num : nums) {
            // Reset on 0
            if (num == 0) {
                currMax = 1;
                currMin = 1;
                continue;
            }

            int tmp = currMax;
            currMax = Math.max(Math.max(num, currMax * num), currMin * num);
            currMin = Math.min(Math.min(num, tmp * num), currMin * num);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
