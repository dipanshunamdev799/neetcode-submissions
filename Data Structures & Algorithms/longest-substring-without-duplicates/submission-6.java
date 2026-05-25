class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;
        HashMap<Character,Integer> mp = new HashMap<>();
        int res = 1;
        int l = 0;
        int len = 0;
        int r = 0;
        while(r<n){
            char ch = s.charAt(r);
            mp.put(ch,1+mp.getOrDefault(ch,0));
            len++;
            while(l!=r && mp.getOrDefault(s.charAt(r),0)>1){
                char c = s.charAt(l);
                mp.put(c,mp.get(c)-1);
                l++;
                len--;
            }
            res = Math.max(len,res);
            r++;
        }
        return res;
    }
}
