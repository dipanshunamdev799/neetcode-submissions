class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;
        int res = 1;
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        mp.put(s.charAt(l),1);
        int len = 1;
        for(int r=1; r<n; r++){
            while(mp.getOrDefault(s.charAt(r),0)==1){
                char ch = s.charAt(l);
                mp.put(ch,mp.get(ch)-1);
                l++;
                len--;
            }
            len++;
            char ch = s.charAt(r);
            mp.put(ch,1+mp.getOrDefault(ch,0));
            res = Math.max(len,res);
        }
        return res;
    }
}
