class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){

            //eliminate useless loops
            if (nums[i] > 0) break;

            //duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int el = nums[i];

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
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
