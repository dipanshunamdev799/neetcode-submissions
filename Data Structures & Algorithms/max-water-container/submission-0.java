class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1 ;
        int ans = 0;
        while(left<right){
            int water = (right-left) * Math.min(heights[left],heights[right]);
            ans = Math.max(ans,water);
            if(heights[left]<heights[right]){
                left++;
            }else if(heights[left]>heights[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return ans;
    }
}
