class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        prefix[0] = Integer.MIN_VALUE;
        suffix[height.length-1] = Integer.MIN_VALUE;
        for(int i=1; i<height.length; i++){
            prefix[i] = Math.max(prefix[i-1],height[i-1]);
            suffix[height.length-1-i] = Math.max(suffix[height.length-i],height[height.length-i]);
        }
        int ans = 0;
        for(int i=0; i<height.length; i++){
            int el = height[i];
            if(el>=Math.min(suffix[i],prefix[i])) continue;
            ans+=Math.min(suffix[i],prefix[i]) - el;
        }
        return ans;
    }
}
