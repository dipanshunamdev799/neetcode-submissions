class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(char ch: t.toCharArray()){
            mapT.putIfAbsent(ch,0);
            mapT.put(ch,mapT.get(ch)+1);
        }
        int l = 0;
        int r = 0;
        int n = s.length();
        HashMap<Character,Integer> mapS = new HashMap<>();
        for(char ch: s.toCharArray()) mapS.putIfAbsent(ch,0);
        while(r<n){
            char ch = s.charAt(r);
            mapS.put(ch,mapS.get(ch)+1);
            if(helper(mapS,mapT)){
                return s.substring(l,r+1);
            }
            while((r-l+1)>t.length()){
                char c = s.charAt(l);
                mapS.put(c,mapS.get(c)-1);
                l++;
            }
            r++;
        }
        return "";
    }
    private boolean helper(HashMap<Character,Integer> mapS,HashMap<Character,Integer> mapT){
        for(Map.Entry<Character,Integer> entry: mapT.entrySet()){
            if(mapS.get(entry.getKey())!=entry.getValue()) return false;
        }
        return true;
    }
}
