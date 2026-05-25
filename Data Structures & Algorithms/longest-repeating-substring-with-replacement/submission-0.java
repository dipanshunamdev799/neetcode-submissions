class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        HashSet<Character> chars = new HashSet<>();
        for(char ch: s.toCharArray()) chars.add(ch);

        int res = 1;

        for(char ch: chars){
            int count = 0; // count of ch
            int l = 0;
            int r = 0;
            while(r<n){
                if(s.charAt(r)==ch) count++;
                while((r-l+1)-count > k){ // number of replacements > k
                    if(s.charAt(l++)==ch) count--;
                }
                res = Math.max(res,(r-l+1));
                r++;
            }
        }
        
        return res;
    }
}
