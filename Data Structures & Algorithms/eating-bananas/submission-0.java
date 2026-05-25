class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = Integer.MAX_VALUE;
        int ans = -1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(eat(piles,h,mid)){
                ans = mid;
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean eat(int[] piles,int h, int k){
        int res = 0;
        for(int x: piles) res+= (x + k - 1) / k;
        return res<=h;
    }
}
