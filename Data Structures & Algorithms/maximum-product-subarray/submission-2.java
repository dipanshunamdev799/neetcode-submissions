class Solution {
    public int maxProduct(int[] nums) {
        List<Integer> negativeCount = new ArrayList<>();
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        Integer negativeCounter = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                negativeCount.add(negativeCounter);
                arrays.add(new ArrayList<>(array));
                negativeCounter=0;
                array.clear();
            }else{
                if(nums[i]<0) negativeCounter++;
                array.add(nums[i]);
            }
        }
        if(!array.isEmpty()){
            arrays.add(new ArrayList<>(array));
            negativeCount.add(negativeCounter);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0; i<arrays.size(); i++){

            array = arrays.get(i);

            if(array.isEmpty()) continue;

            Integer negCount = negativeCount.get(i);
            if(array.size()==1 && negCount==1) continue;

            if(negCount%2==0){
                int product = 1;
                for(int j=0; j<array.size(); j++){
                    product*=array.get(j);
                }
                res = Math.max(res,product);
            }else{
                int product = 1;
                for(int j=0; j<array.size(); j++){
                    product*=array.get(j);
                }
                int product1 = 1;
                int product2 = 1;
                for(int j=0; j<array.size(); j++){
                    product1*=array.get(j);
                    if(array.get(j)<0){
                        break;
                    }
                }
                for(int j=array.size()-1; j>=0; j--){
                    product2*=array.get(j);
                    if(array.get(j)<0){
                        break;
                    }
                }
                res = Math.max(res,product/product1);
                res = Math.max(res,product/product2);
            }
        }
        //consider zeros if all negatives result to a negative outcome e.g. [-1,0,-2,0,-3]
        for(int val: nums){
            res = Math.max(res,val);
        }
        return res;
    }
}
