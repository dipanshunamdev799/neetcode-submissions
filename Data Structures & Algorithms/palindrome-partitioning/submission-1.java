class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        // if(isPalindrome(s)){
        //     res.add(new ArrayList<>());
        //     res.get(0).add(s);
        // }
        helper(s,res,new ArrayList<>());
        return res;
    }
    private void helper(String s,List<List<String>> res,ArrayList<String> temp){
        if(s.length()==1){
            temp.add(s);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        for(int i=1; i<=s.length(); i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            if(isPalindrome(s1)){
                temp.add(s1);
                helper(s2,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
