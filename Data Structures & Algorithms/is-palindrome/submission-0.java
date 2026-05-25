class Solution {
    private static boolean isLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
           (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        String str = "";
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(isLetterOrDigit(s.charAt(i))){
                Character ch = s.charAt(i);
                str+= ch.toString();
            }
        }
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
