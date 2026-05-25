class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if(n==0) return 0;   //no houses available
        if(n==1) return nums[0];   //only one house
        if(n==2) return Math.max(nums[0],nums[1]);    //only 2 houses

        int x,y;
        
        x = helper(Arrays.copyOfRange(nums,0,nums.length-1));
        y = helper(Arrays.copyOfRange(nums,1,nums.length));
        return Math.max(x,y);
    }
    public int helper(int[] nums){
        int n = nums.length;

        if(n==0) return 0;   //no houses available
        if(n==1) return nums[0];   //only one house
        if(n==2) return Math.max(nums[0],nums[1]);    //only 2 houses

        int dp[] = new int[n];    // 3 or more houses
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[n-1];
    }
}
