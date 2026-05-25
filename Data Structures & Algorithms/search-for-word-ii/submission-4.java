class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree pt = new PrefixTree();
        for(String word: words){
            pt.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(i,j,pt.root,res,board,visited,sb);
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(int i,int j, TrieNode node, Set<String> res, char[][] board,int[][] visited,StringBuilder sb){

        if(visited[i][j]==1) return;

        visited[i][j] = 1;
        sb.append(board[i][j]);

        int index = board[i][j] - 'a';
        if(node.children[index]==null){
            visited[i][j] = 0;
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(node.children[index].isEndOfWord) res.add(sb.toString());

        int m = board.length;
        int n = board[0].length;

        if(i+1 < m) dfs(i+1,j,node.children[index],res,board,visited,sb);
        if(i-1 >= 0) dfs(i-1,j,node.children[index],res,board,visited,sb);
        if(j+1 <n) dfs(i,j+1,node.children[index],res,board,visited,sb);
        if(j-1 >=0) dfs(i,j-1,node.children[index],res,board,visited,sb);

        visited[i][j] = 0;
        sb.deleteCharAt(sb.length()-1);
    }
}
class TrieNode{
    boolean isEndOfWord = false;
    TrieNode[] children = new TrieNode[26];
}
class PrefixTree{

    TrieNode root;

    PrefixTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
}
