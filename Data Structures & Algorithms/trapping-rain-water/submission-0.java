class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        prefix[0] = Integer.MIN_VALUE;
        suffix[height.length-1] = prefix[0];
        for(int i=1; i<height.length; i++){
            int x = height[i];
            prefix[i] = Math.max(prefix[i-1],x);
            int y = height[height.length-1-i];
            suffix[height.length-1-i] = Math.max(suffix[height.length-i],y);
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
