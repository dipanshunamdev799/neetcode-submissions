class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> mp = new HashMap<>();
        for(String str: strs){
            HashMap<Character,Integer> tmp = new HashMap<>();
            for(char ch: str.toCharArray()){
                tmp.putIfAbsent(ch,0);
                tmp.put(ch,tmp.get(ch)+1);
            }
            mp.putIfAbsent(tmp,new ArrayList<>());
            mp.get(tmp).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<HashMap<Character,Integer>,List<String>> entry: mp.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
