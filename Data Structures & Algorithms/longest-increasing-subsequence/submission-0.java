public class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int prev) {

        if (i == nums.length) {
            return 0;
        }


        int LIS = dfs(nums, i + 1, prev); // not include

        if (prev == -1 || nums[prev] < nums[i]) {  // prev not there OR prev smaller 
            int x = 1 + dfs(nums, i + 1, i); // include
            LIS = Math.max(x,LIS);
        }

        return LIS;
    }
}