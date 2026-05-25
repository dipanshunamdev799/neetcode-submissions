class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            char charL = s.charAt(l);
            char charR = s.charAt(r);
            if(!Character.isLetterOrDigit(charL)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(charR)){
                r--;
                continue;
            }
            if(charL != charR) return false;
            l++;
            r--;
        }
        return true;
    }
}
