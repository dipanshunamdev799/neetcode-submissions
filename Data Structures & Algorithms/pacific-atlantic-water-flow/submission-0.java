class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==0){
                    dfs(heights,pacific,atlantic,visited,i,j);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        
        return res;
    }
    private void dfs(int[][] heights,int[][] pacific,int[][] atlantic,int[][] visited,int i,int j){
        if(visited[i][j]==0){

            visited[i][j] = 1;

            int m = heights.length;
            int n = heights[0].length;

            if(i==0) pacific[i][j] = 1;
            if(j==0) pacific[i][j] = 1;
            if(i==m-1) atlantic[i][j] = 1;
            if(j==n-1) atlantic[i][j] = 1;

            if(i+1<m && heights[i+1][j]<=heights[i][j]){
                dfs(heights,pacific,atlantic,visited,i+1,j);
                if(pacific[i][j]==0)
                pacific[i][j] = pacific[i+1][j];
                if(atlantic[i][j]==0)
                atlantic[i][j] = atlantic[i+1][j];
            }
            if(i-1>=0 && heights[i-1][j]<=heights[i][j]){
                dfs(heights,pacific,atlantic,visited,i-1,j);
                if(pacific[i][j]==0)
                pacific[i][j] = pacific[i-1][j];
                if(atlantic[i][j]==0)
                atlantic[i][j] = atlantic[i-1][j];
            }
            if(j+1<n && heights[i][j+1]<=heights[i][j]){
                dfs(heights,pacific,atlantic,visited,i,j+1);  
                if(pacific[i][j]==0)
                pacific[i][j] = pacific[i][j+1];
                if(atlantic[i][j]==0)
                atlantic[i][j] = atlantic[i][j+1];
            }
            if(j-1>=0 && heights[i][j-1]<=heights[i][j]){
                dfs(heights,pacific,atlantic,visited,i,j-1);
                if(pacific[i][j]==0)
                pacific[i][j] = pacific[i][j-1];
                if(atlantic[i][j]==0)
                atlantic[i][j] = atlantic[i][j-1];
            }

        }
        
    }
}