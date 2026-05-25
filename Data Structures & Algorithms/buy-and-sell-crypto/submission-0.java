class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buy = prices[0];
        for(int sell: prices){
            buy = Math.min(buy,sell);
            ans = Math.max(ans, sell-buy);
        }
        return ans;
    }
}
