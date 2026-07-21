class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int length = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                length--;
            }else{
                set.add(ch);
                length++;
            }
            ans = Math.max(ans,length);
        }
        return ans;
    }
}
