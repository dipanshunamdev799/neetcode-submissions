class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
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

        // In case the max is 0 or a single number like -1, also compare with all nums
        for (int num : nums) {
            res = Math.max(res, num);
        }

        return res;
    }
}
