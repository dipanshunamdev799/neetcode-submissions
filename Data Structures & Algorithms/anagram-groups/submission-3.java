class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> mp = new HashMap();
        for(String str: strs){
            char[] str1 = str.toCharArray();
            Arrays.sort(str1);
            mp.putIfAbsent(new String(str1),new ArrayList<>());
            mp.get(new String(str1)).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> entry : mp.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
