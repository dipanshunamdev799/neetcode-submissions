class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;
        int res = 1;
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int len = 1;
        int r = 0;
        while(r<n){
            while(mp.getOrDefault(s.charAt(r),0)==1){
                char c = s.charAt(l);
                mp.put(c,mp.get(c)-1);
                l++;
                len--;
            }
            res = Math.max(len,res);
            char ch = s.charAt(r);
            mp.put(ch,1+mp.getOrDefault(ch,0));
            len++;
            r++;
        }
        return res;
    }
}
