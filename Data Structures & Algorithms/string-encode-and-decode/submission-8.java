class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            int n = str.length();
            res.append(Integer.toString(n));
            res.append("#");
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.length()==0) return res;
        helper(res,str,0);
        return res;
    }

    private void helper(List<String> res,String str, int index){
        if(index>=str.length()) return;
        int start = index;
        while(Character.isDigit(str.charAt(index))){
            index++;
        }
        // now index is at #
        int num = Integer.parseInt(str.substring(start,index));
        res.add(str.substring(index+1,index+1+num));
        helper(res,str,index+num+1);
    }
}
