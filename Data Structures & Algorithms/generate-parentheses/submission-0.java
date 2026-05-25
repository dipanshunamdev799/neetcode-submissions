class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb,res,n*2,0,0);
        return res;
    }
    private void helper(StringBuilder sb,List<String> res,int n, int open, int close){
        if(close>open){
            return;
        }
        if(open>n){
            return;
        }
        if(open+close==n && open==close){
            res.add(sb.toString());
        }
        if(open<=n){
            sb.append("(");
            helper(sb,res,n,open+1,close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(")");
            helper(sb,res,n,open,close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
