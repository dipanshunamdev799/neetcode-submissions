class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tracker = new ArrayList<>();
        helper(0,nums,target,res,tracker);
        return res;
    }
    private void helper(int depth,int[] nums,int target,List<List<Integer>> res,List<Integer> tracker){
        if(target==0){
            res.add(new ArrayList<>(tracker));
            return;
        }

        if(target<0) return;

        for(int i=depth; i<nums.length; i++){
            int el = nums[i];
            tracker.add(el);
            helper(i,nums,target-el,res,tracker);
            tracker.remove(tracker.size()-1);
        }
    }
}
