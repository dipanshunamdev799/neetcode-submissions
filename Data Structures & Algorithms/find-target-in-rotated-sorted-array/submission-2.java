class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]){   // sorted part
                r = mid;
            }else{   //rotated part
                l = mid + 1;
            }
        }
        // now we have the index of mini element
        int x = binarySearch(nums,0,l-1,target);
        int y = binarySearch(nums,l,nums.length-1,target);
        if(x!=-1) return x;
        return y;
    }
    private int binarySearch(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
