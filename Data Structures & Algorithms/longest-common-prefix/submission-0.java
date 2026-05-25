class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder res = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++){
            int j = 0;
            String str = strs[i];
            while(j < Math.min(res.length(),str.length())){
                if(str.charAt(j)!=res.charAt(j)){
                    break;
                }
                j++;
            }
            res = new StringBuilder(res.substring(0,j));
        }
        return res.toString();
    }
}