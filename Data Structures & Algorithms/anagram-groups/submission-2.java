class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,ArrayList> mp = new HashMap<>();
        for(String str: strs){
            int[] nums = new int[26];
            for(char ch: str.toCharArray()) nums[ch-'a']++;
            String key = Arrays.toString(nums);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(str);
        }
        for(Map.Entry<String,ArrayList> entry: mp.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
