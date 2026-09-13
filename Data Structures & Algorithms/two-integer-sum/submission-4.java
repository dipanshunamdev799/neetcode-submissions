
class Solution {
    public record Pair(int value,int index){}
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Pair> array = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            array.add(new Pair(nums[i],i));
        }
        array.sort((a, b) -> a.value() - b.value());
        int left = 0;
        int right = array.size()-1;
        while(array.get(left).value()+array.get(right).value()!=target){
            int sum = array.get(left).value() + array.get(right).value();
            if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{Math.min(array.get(left).index(),array.get(right).index()),Math.max(array.get(left).index(),array.get(right).index())};
    }
}
