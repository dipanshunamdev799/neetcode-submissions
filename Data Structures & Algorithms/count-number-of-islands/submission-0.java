class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(grid[i][j]=='1'){
            grid[i][j] = '0';
            if(i+1 < n && grid[i+1][j]=='1'){
                dfs(grid,i+1,j);
            }
            if(j+1<m && grid[i][j+1]=='1'){
                dfs(grid,i,j+1);
            }
            if(i-1 >=0 && grid[i-1][j]=='1'){
                dfs(grid,i-1,j);
            }
            if(j-1 >= 0 && grid[i][j-1]=='1'){
                dfs(grid,i,j-1);
            }
        }
    }
}
