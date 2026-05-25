class Solution {
    public int trap(int[] height) {
        int res =0;
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int left = 0;
        int right = n-1;
        while(left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                left++;
                int water = leftMax - height[left];
                if(water>0) res+= water;
            }else{
                right--;
                int water = rightMax - height[right];
                if(water>0) res+= water;
            }
        }
        return res;
    }
}
