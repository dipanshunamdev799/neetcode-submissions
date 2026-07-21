class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;
        int res = 1;
        int[] letters = new int[26];
        int l = 0;
        letters[s.charAt(l)-'a']++;
        int len = 1;
        for(int r=1; r<n; r++){
            while(letters[s.charAt(r)-'a']==1){
                letters[s.charAt(l++)-'a']--;
                len--;
            }
            len++;
            letters[s.charAt(r)-'a']++;
            res = Math.max(len,res);
        }
        return res;
    }
}
