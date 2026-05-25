class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int i=0; i<n; i++){
            adjMap.putIfAbsent(i,new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adjMap.get(x).add(y);
            adjMap.get(y).add(x);
        }
        boolean res =  dfs(0,-1,adjMap,visited);
        if(res==false) return false;
        for(int i=0; i<n; i++){   //any node left unvisited in dfs
            if(visited[i]==0) return false;
        }
        return true;
    }
    private boolean dfs(int i,int parent,HashMap<Integer,List<Integer>> adjMap,int[] visited){
        if(visited[i]==1) return false;  // if encountered again => cycle
        visited[i] = 1;
        boolean res = true;
        for(Integer x: adjMap.get(i)){  // kyu ?
            if(x!=parent){
                res = res && dfs(x,i,adjMap,visited);
            }
        }
        return res;
    }
}
