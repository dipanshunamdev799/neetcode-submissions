class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int nums[] = new int[26];
        for(char x: s.toCharArray()){
            nums[x-'a']++;
        }
        for(char x: t.toCharArray()){
            nums[x-'a']--;
            if(nums[x-'a']==-1) return false;
        }
        return true;
    }
}
