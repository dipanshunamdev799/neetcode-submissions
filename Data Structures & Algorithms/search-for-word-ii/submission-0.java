class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word: words){
            if(wordSearch(board,word)) res.add(word);
        }
        return res;
    }
    private boolean wordSearch(char[][] board, String word){
        int n = board.length;
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(i,j,0,board,word,visited)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,int idx,char[][] board,String word,int[][] visited){
        if(visited[i][j]==0){
            visited[i][j] = 1;

            if(idx==word.length()-1){
                visited[i][j] = 0;
                if(board[i][j]== word.charAt(idx)){
                    return true;
                }else{
                    return false;
                }
            }

            boolean res = false;

            if(board[i][j]==word.charAt(idx)){
                if(i+1 < board.length) res = res || dfs(i+1,j,idx+1,board,word,visited);
                if(!res && i-1 >= 0) res = res || dfs(i-1,j,idx+1,board,word,visited); 
                if(!res && j+1 < board.length) res = res || dfs(i,j+1,idx+1,board,word,visited);
                if(!res && j-1 >= 0) res = res || dfs(i,j-1,idx+1,board,word,visited);
            }else{
                visited[i][j] = 0;
                return false;
            }

            visited[i][j] = 0;
            return res;
        }else{
            return false;
        }
    }
}
