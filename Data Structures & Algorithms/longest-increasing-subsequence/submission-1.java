public class Solution {
    Integer dp[][];
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length+1][nums.length+1];
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int prev) {

        if(prev!=-1)
        if(dp[i][prev]!=null) return dp[i][prev];

        if (i == nums.length) {
            if(prev!=-1)
            dp[i][prev] = 0;
            return 0;
        }


        int LIS = dfs(nums, i + 1, prev); // not include

        if (prev == -1 || nums[prev] < nums[i]) {  // prev not there OR prev smaller 
            int x = 1 + dfs(nums, i + 1, i); // include
            LIS = Math.max(x,LIS);
        }
        if(prev!=-1)
        dp[i][prev] = LIS;
        return LIS;
    }
}