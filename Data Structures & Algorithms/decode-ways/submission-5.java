class Solution {
    private int[] dp;
    public int numDecodings(String s) {
        int n= s.length();
        dp = new int[n+1]; 
        dp[n] = 1;  //one way to decode empty string
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i+1]; //decode only one char

                //decode i & i+1 
                if((i+1<n) && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                    dp[i] += dp[i+2];
                }
            }
        } 

        return dp[0];  // no of ways to decode substr s[0...end]
    }
}
