class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str).append("#");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] strs = str.split("#");
        List<String> res = new ArrayList<>();
        for(String s : strs) res.add(s);
        return res;
    }
}
