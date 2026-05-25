class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int n = str.length();
            sb.append("" + n);
            sb.append(",");
        }
        sb.append("#");
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        if(str.length()==1) return new ArrayList<>();
        for(i=0; i<str.length(); i++){
            if(str.charAt(i)=='#') break;
        }
        String[] lengths = str.substring(0,i).split(",");
        List<String> res = new ArrayList<>();
        i++;
        for(String lenString: lengths){
            Integer len = Integer.parseInt(lenString);
            if(len==null) continue;
            res.add(str.substring(i,i+len));
            i+=len;
        }
        return res;
    }
}
