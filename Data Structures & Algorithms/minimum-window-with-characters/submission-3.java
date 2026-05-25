class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> mapT = new HashMap<>();
        HashMap<Character,Integer> mapS = new HashMap<>();

        for(char ch: t.toCharArray()){
            mapT.putIfAbsent(ch,0);
            mapS.putIfAbsent(ch,0);
            mapT.put(ch,mapT.get(ch)+1);
        }
        for(char ch: s.toCharArray()){
            mapS.putIfAbsent(ch,0);
            mapT.putIfAbsent(ch,0);
        } 

        int l = 0;
        int r = 0;
        int n = s.length();

        String res = "";
        while(r<n){

            char ch = s.charAt(r);
            mapS.put(ch,mapS.get(ch)+1);

            while(helper(mapS,mapT)){
                String tmp = s.substring(l,r+1);
                if(res.equals("")){
                    res = tmp;
                }else{
                    if(tmp.length() < res.length()) res = tmp;
                }
                char c = s.charAt(l);
                mapS.put(c,mapS.get(c)-1);
                l++;
            }
            r++;
        }
        return res;
    }
    private boolean helper(HashMap<Character,Integer> mapS,HashMap<Character,Integer> mapT){
        for(Map.Entry<Character,Integer> entry: mapT.entrySet()){
            if(!(mapS.get(entry.getKey())>=entry.getValue())) return false;
        }
        return true;
    }
}
