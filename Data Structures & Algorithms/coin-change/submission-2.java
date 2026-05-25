class Solution {
    public int helper(int[] coins,int amount,HashMap<Integer,Integer> dp){
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(dp.containsKey(amount)) return dp.get(amount);
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            int subRes = helper(coins,amount-coin,dp);
            if(subRes>=0){
                res = Math.min(res,1+subRes);
            }
        }
        dp.put(amount,(res==Integer.MAX_VALUE)? -1 : res);
        return dp.get(amount);
    }
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        return helper(coins,amount,dp);
    }
}
