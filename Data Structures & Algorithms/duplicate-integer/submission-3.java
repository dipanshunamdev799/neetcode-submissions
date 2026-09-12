class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int x: nums){
            if(hashSet.contains(x)) return true;
            hashSet.add(x);
        }
        return false;
    }
}