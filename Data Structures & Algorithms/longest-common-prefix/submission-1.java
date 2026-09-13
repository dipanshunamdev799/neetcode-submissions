class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++){
            int j=0;
            for(;j<Math.min(strs[i].length(),res.length());j++){
                if(strs[i].charAt(j)!=res.charAt(j)) break;
            }
            res.setLength(j);
        }        
        return res.toString();
    }
}