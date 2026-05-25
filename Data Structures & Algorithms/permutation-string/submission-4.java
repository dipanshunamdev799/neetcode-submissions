class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        int[] arr = new int[26]; //s1
        int[] temp = new int[26];   //s2

        for(int i=0; i<n1; i++){
            arr[s1.charAt(i)-'a']++;
            temp[s2.charAt(i)-'a']++;
        }

        if(matches(arr,temp)) return true;
        
        for(int i=n1; i<n2; i++){

            temp[s2.charAt(i)-'a']++;
            temp[s2.charAt(i-n1)-'a']--;

            if(matches(arr,temp)) return true;

        }
        return false;
    }

    private boolean matches(int[] arr,int[] temp){
        for(int i=0; i<26; i++){
            if(arr[i]!=temp[i]) return false;
        }
        return true;
    }

}
