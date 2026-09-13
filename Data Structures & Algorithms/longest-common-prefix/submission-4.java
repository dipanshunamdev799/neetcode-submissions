class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(true){
            char c = '\0';
            try{
                c = strs[0].charAt(i);
            }catch (Exception e){
                break;
            }
            boolean exit = false;
            for(String str: strs){
                if(str.length()<i){ exit = true; break;}
                if(str.charAt(i)!=c){exit = true; break;}
            }
            if(exit) break;
            res.append(c);
            i++;
        }
        return res.toString();
    }
}