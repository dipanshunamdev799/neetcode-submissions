import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // for O(1) lookup
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, wordSet, dp);
    }

    private boolean helper(int i, String s, Set<String> wordSet, Boolean[] dp) {
        if (i == s.length()) return true;
        if (dp[i] != null) return dp[i];

        for (String word : wordSet) {
            int end = i + word.length();
            if (end <= s.length() && s.substring(i, end).equals(word)) {
                if (helper(end, s, wordSet, dp)) {
                    dp[i] = true;
                    return true;
                }
            }
        }

        dp[i] = false;
        return false;
    }
}
