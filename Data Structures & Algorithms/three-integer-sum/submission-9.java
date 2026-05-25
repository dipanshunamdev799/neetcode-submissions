class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        while(i < n-2 ){

            int j = i+1;
            int k = n-1;
            int target = (-1) * nums[i];

            while(j<k){
                int sum = nums[j] + nums[k];
                if(target == sum){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                }else if(target < sum){
                    k--;
                }else{
                    j++;
                }
            }
            i++;
        }
        return new ArrayList<>(res);
    }
}
