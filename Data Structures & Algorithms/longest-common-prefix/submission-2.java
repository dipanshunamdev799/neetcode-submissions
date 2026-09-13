class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(true){
            char c = strs[0].charAt(i);
            boolean exit = false;
            for(String str: strs){
                if(str.length()<i) exit = true;;
                if(str.charAt(i)!=c) exit = true;
            }
            if(exit) break;
            res.append(c);
            i++;
        }
        return res.toString();
    }
}