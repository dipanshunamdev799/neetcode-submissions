class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getComponentsCount();
    }
}
class UnionFind{
    int components;
    int parent[];
    UnionFind(int n){
        components = n;
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY) return;
        if(rootX!=rootY){
            parent[rootX] = rootY;
        }
        components--;
    }
    boolean connected(int x,int y){
        if(find(x)==find(y)) return true;
        return false;
    }
    int getComponentsCount(){
        return components;
    }
}