class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for(String str: strs){
            ans+= "#" + ((Integer)str.length()).toString() +"#" + str;
        }
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while(index<str.length()){
            //skip first #
            index++;
             
            int countStart = index;
            while(index<str.length() && ( str.charAt(index)>='0' && str.charAt(index)<='9' )) index++;
            Integer len = Integer.valueOf(str.substring(countStart,index));
            
            //skip next #
            index++;

            String s = str.substring(index,index+len);
            ans.add(s);
            index+= len;
        }
        return ans;
    }
}
