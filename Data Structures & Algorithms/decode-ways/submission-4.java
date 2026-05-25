class Solution {
    private int[] dp;
    public int numDecodings(String s) {
        int n= s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(0,s);
    }
    private int dfs(int i,String s){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int res = dfs(i+1,s);
        if(i<s.length()-1){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7') ){
                res+= dfs(i+2,s);
            }
        }
        dp[i] = res;
        return res;
    }
}
