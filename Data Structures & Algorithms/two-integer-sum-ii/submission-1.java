class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[] res = new int[2];
        while(start<end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                res[0] = 1+start;
                res[1] = 1+end;
                return res;
            }else if (sum < target){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}
