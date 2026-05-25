class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> adjMap = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        int n = words.length;

        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adjMap.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build graph
        for (int i = 1; i < n; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            if (word1.startsWith(word2) && word1.length() > word2.length()) {
                return ""; // Invalid order
            }

            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!adjMap.get(c1).contains(c2)) {
                        adjMap.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break; // Only first different character matters
                }
            }
        }

        List<Character> resArray = topologicalSort(adjMap, inDegree);

        // Cycle detection: result size must match number of unique characters
        if (resArray.size() < inDegree.size()) return "";

        StringBuilder res = new StringBuilder();
        for (char c : resArray) {
            res.append(c);
        }
        return res.toString();
    }

    private List<Character> topologicalSort(HashMap<Character, HashSet<Character>> adjMap,
                                            HashMap<Character, Integer> inDegreeOriginal) {
        List<Character> result = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();

        // Make a copy of inDegree to avoid modifying the original
        HashMap<Character, Integer> inDegree = new HashMap<>(inDegreeOriginal);

        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.add(curr);

            for (char neighbor : adjMap.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}
