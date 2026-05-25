class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return helper(0,s,wordDict);
    }
    private boolean helper(int i,String s,List<String> wordDict){
        if(memo[i]!=null) return memo[i];
        if(i==s.length()){
            memo[s.length()] = true;
            return true;
        }
        for(String w: wordDict){
            if((i+w.length()) <= s.length() && s.substring(i,i+w.length()).equals(w)){
                if(helper(i+w.length(),s,wordDict)){
                    memo[i+w.length()] = true;
                    return true;
                } 
            }
        }
        memo[i] = false;
        return false;
    }
}
