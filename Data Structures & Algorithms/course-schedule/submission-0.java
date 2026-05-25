class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> adjMap = new HashMap<>();
        HashMap<Integer,Integer> inDegree = new HashMap<>();

        for(int i=0; i<prerequisites.length; i++){
            int x = prerequisites[i][1];
            int y = prerequisites[i][0];
            adjMap.putIfAbsent(x,new HashSet<>());
            adjMap.putIfAbsent(y,new HashSet<>());
            inDegree.putIfAbsent(x,0);
            inDegree.putIfAbsent(y,0);
        }
        for(int i=0; i<prerequisites.length; i++){
            int x = prerequisites[i][1];
            int y = prerequisites[i][0];
            //x -> y
            if(!adjMap.get(x).contains(y)){
                adjMap.get(x).add(y);
                inDegree.put(y,inDegree.get(y)+1);
            }
        }
        List<Integer> res = topologicalSort(adjMap,inDegree);
        return res.size() == inDegree.size();
    }
    private List<Integer> topologicalSort(HashMap<Integer,HashSet<Integer>> adjMap,HashMap<Integer,Integer> inDegree){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            if(entry.getValue()==0){
                queue.add(entry.getKey());
            }
        }
        while(!queue.isEmpty()){
            int top = queue.element();
            queue.remove();
            res.add(top);
            for(Integer x : adjMap.get(top)){
                inDegree.put(x,inDegree.get(x)-1);
                if(inDegree.get(x)==0){
                    queue.add(x);
                }
            }
        }
        return res;

    }
}   
