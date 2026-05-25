class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character,HashSet<Character>> adjMap = new HashMap<>();
        HashMap<Character,Integer> inDegree = new HashMap<>();
        int n = words.length;

        // Initialize all characters with in-degree 0
        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adjMap.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build the graph
        for(int i = 1; i < n; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            int n1 = word1.length();
            int n2 = word2.length();
            
            // Check for invalid case: longer prefix comes after shorter one
            if(n1 > n2 && word1.startsWith(word2)) {
                return ""; // Invalid ordering
            }

            for(int j = 0; j < Math.min(n1, n2); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2){
                    // Only add edge if it doesn't already exist
                    if(!adjMap.get(c1).contains(c2)){
                        adjMap.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break; // Important: only consider first differing character
                }
            }
        }

        List<Character> resArray = topologicalSort(adjMap, inDegree);
        
        // Check if topological sort was successful (no cycles)
        if(resArray.size() != inDegree.size()) {
            return ""; // Cycle detected
        }
        
        StringBuilder res = new StringBuilder();
        for(char c : resArray){
            res.append(c);
        }
        return res.toString();
    }
    
    private List<Character> topologicalSort(HashMap<Character,HashSet<Character>> adjMap, HashMap<Character,Integer> inDegree){
        List<Character> res = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0 to queue
        for(HashMap.Entry<Character,Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }
        
        while(!queue.isEmpty()){
            char ch = queue.poll(); // Use poll() instead of element() + remove()
            res.add(ch);
            
            // Check if current character has outgoing edges
            if(adjMap.containsKey(ch)) {
                for(Character neighbor : adjMap.get(ch)){
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if(inDegree.get(neighbor) == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}