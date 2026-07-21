class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0;
        int r = prices.length-1;
        int lmax = Integer.MAX_VALUE;
        int rmax = Integer.MIN_VALUE;
        while(l<r){
            lmax = Math.min(lmax,prices[l]);
            rmax = Math.max(rmax,prices[r]);
            res = Math.max(res,rmax-lmax);
            l++;
            r--;
        }
        return res;
    }
}
