class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            int subRes = coinChange(coins,amount-coin);
            if(subRes>=0){
                res = Math.min(res,1+subRes);
            }
        }
        if(res==Integer.MAX_VALUE) return -1;
        return res;
    }
}
