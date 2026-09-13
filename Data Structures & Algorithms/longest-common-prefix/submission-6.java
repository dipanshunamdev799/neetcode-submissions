class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(true){
            if(strs[0].length()<=i) break;
            char c = strs[0].charAt(i);
            boolean exit = false;
            for(String str: strs){
                if(str.length()<=i){ exit = true; break;}
                if(str.charAt(i)!=c){exit = true; break;}
            }
            if(exit) break;
            res.append(c);
            i++;
        }
        return res.toString();
    }
}