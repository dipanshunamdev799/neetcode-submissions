class Solution {
    public String foreignDictionary(String[] words) {

        HashMap<Character,HashSet<Character>> adjMap = new HashMap<>();
        HashMap<Character,Integer> inDegree = new HashMap<>();

        int n = words.length;

        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adjMap.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i=1; i<n; i++){

            String word1 = words[i-1];
            String word2 = words[i];

            int n1 = word1.length();
            int n2 = word2.length();

            if (word1.startsWith(word2) && word1.length() > word2.length()) {
                return "";
            }

            for(int j=0; j<Math.min(n1,n2); j++){

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1!=c2){
                    if(!adjMap.get(c1).contains(c2)){
                        adjMap.get(c1).add(c2);
                        inDegree.put(c2,inDegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        List<Character> resArray = topologicalSort(adjMap,inDegree);

        if (resArray.size() != inDegree.size()) return "";   //cycle detection

        StringBuilder res = new StringBuilder("");
        for(int i=0; i<resArray.size(); i++){
            res.append(resArray.get(i));
        }
        return res.toString();
    }
    private List<Character> topologicalSort(HashMap<Character,HashSet<Character>> adjMap,HashMap<Character,Integer> inDegree){
        List<Character> res = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        for(HashMap.Entry<Character,Integer> entry: inDegree.entrySet()){
            if(entry.getValue()==0){
                queue.add(entry.getKey());
            }
        }
        while(!queue.isEmpty()){
            char ch = queue.poll();
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
