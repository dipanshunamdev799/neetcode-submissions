class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prefixMin = new int[n];
        prefixMin[0] = prices[0];
        for(int i=1; i<n; i++) prefixMin[i] = Math.min(prefixMin[i-1],prices[i]);

        int[] suffixMax = new int[n];
        suffixMax[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--) suffixMax[i] = Math.max(prices[i],suffixMax[i+1]);

        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res,suffixMax[i]-prefixMin[i]);
        }

        return res;
    }
}
