class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int prefixMax[] = new int[n];
        int suffixMax[] = new int[n];
        prefixMax[0] = Integer.MIN_VALUE;
        suffixMax[n-1] = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1],height[i-1]);
            suffixMax[n-i-1] = Math.max(suffixMax[n-i],height[n-i]);
        }
        for(int i=1; i<n-1; i++){
            int x = Math.min(prefixMax[i],suffixMax[i]) - height[i];
            res += x>0 ? x : 0;
        }
        return res;
    }
}
