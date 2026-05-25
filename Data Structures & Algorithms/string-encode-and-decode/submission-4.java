class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) sb.append(Integer.toString(str.length())).append(",");
        sb.append("#");
        for(String str: strs) sb.append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.length()==1) return res;
        int n = str.length();
        int i;
        for(i=0; i<n; i++) if(str.charAt(i)=='#') break;
        String[] stringLength = str.substring(0,i-1).split(",");
        int[] lengths = new int[stringLength.length];
        for(int j=0; j<stringLength.length; j++){
            lengths[j] = Integer.parseInt(stringLength[j]);
        }
        i++; // now we are at first char of first string
        int idx = 0;
        while(idx<lengths.length){
            res.add(str.substring(i,lengths[idx]+i));
            i+=lengths[idx++];
        }
        return res;
    }
}
