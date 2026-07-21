class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(0,s,wordDict);
    }
    private boolean helper(int i,String s,List<String> wordDict){
        if(i==s.length()) return true;
        boolean ans = false;
        for(String w: wordDict){
            if(s.substring(i,i+w.length()).equals(w)){
                ans = ans || helper(i+w.length(),s,wordDict);
            }
        }
        return ans;
    }
}
