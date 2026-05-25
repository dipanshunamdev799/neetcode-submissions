class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums) set.add(x);
        int res = 0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(set.contains(x-1)) continue;
            int len = 1;
            while(set.contains(++x)) len++;
            res = Math.max(res,len);
        }
        return res;
    }
}
