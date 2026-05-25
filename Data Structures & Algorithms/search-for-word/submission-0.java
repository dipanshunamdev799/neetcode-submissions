class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n= board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(i,j,0,board,word,visited)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int idx,char[][] board,String word,boolean[][] visited){

        if(visited[i][j]) return false;

        visited[i][j] = true;

        char ch = word.charAt(idx);
        int N = word.length();
        int m = board.length;
        int n = board[0].length;

        if(N-1==idx){
            visited[i][j] = false;
            if(ch==board[i][j]){
                return true;
            }else{
                return false;
            }
        }
        
        boolean res = false;

        if(ch==board[i][j]){
            if(i+1<m) res = res || dfs(i+1,j,idx+1,board,word,visited);
            if(!res && i-1>=0) res = res || dfs(i-1,j,idx+1,board,word,visited);
            if(!res &&j+1<n) res = res || dfs(i,j+1,idx+1,board,word,visited);
            if(!res &&j-1>=0) res = res || dfs(i,j-1,idx+1,board,word,visited);
            visited[i][j] = false;
            return res;
        }else{
            visited[i][j] = false;
            return res;
        }
    }
}
