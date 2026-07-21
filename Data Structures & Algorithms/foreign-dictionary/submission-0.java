class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character,List<Character>> adjMap = new HashMap<>();
        HashMap<Character,Integer> inDegree = new HashMap<>();
        int n = words.length;

        for(String word: words){
            for(char ch : word.toCharArray()){
                adjMap.putIfAbsent(ch,new ArrayList<>());
                inDegree.putIfAbsent(ch,0);
            }
        }

        for(int i=1; i<n; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            int n1 = word1.length();
            int n2 = word2.length();

            for(int j=0; j<Math.min(n1,n2); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1!=c2){
                    adjMap.get(c1).add(c2);
                    inDegree.put(c2,inDegree.get(c2)+1);
                    break;
                }
            }
        }

        List<Character> resArray = topologicalSort(adjMap,inDegree);
        StringBuilder res = new StringBuilder("");
        for(int i=0; i<resArray.size(); i++){
            res.append(resArray.get(i));
        }
        return res.toString();
    }
    private List<Character> topologicalSort(HashMap<Character,List<Character>> adjMap,HashMap<Character,Integer> inDegree){
        List<Character> res = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        for(HashMap.Entry<Character,Integer> entry: inDegree.entrySet()){
            if(entry.getValue()==0){
                queue.add(entry.getKey());
            }
        }
        while(!queue.isEmpty()){
            char ch = queue.element();
            queue.remove();
            for(Character neighbor: adjMap.get(ch)){
                inDegree.put(neighbor,inDegree.get(neighbor)-1);
                if(inDegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
            res.add(ch);
        }
        return res;
    }
}
