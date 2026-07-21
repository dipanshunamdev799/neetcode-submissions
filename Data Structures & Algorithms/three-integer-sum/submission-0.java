class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int el = nums[i];
            int temp = i;
            while(temp+1 < nums.length && nums[temp+1]==el) temp++;

            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[left] + nums[right]+el;
                if(sum==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
            i = temp;
        }
        return ans;
    }
}
