class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            while(idx < s.length() && set.contains(ch)){
                set.remove(s.charAt(idx++));
            }
            set.add(ch);
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
