

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int mini = 0;
        for(int i=1; i<strs.length; i++){
            if(strs[mini].length()>strs[i].length()) mini = i;
        }
        Trie trie = new Trie();
        trie.insert(strs[mini]);

        int prefixLen = strs[mini].length();

        for(int i=0; i<strs.length; i++){
            prefixLen = trie.lcp(strs[i],prefixLen);
        }

        return strs[0].substring(0,prefixLen);

    }
}

class Trie{

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            }else{
                TrieNode temp = new TrieNode();
                node.children.put(ch,temp);
                node = temp;
            }
        }
    }

    public int lcp(String word,int prefixLen){
        int len = 0;
        TrieNode node = root;
        for(int i=0; i<Math.min(word.length(),prefixLen); i++){
            char ch = word.charAt(i);
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            }else{
                break;
            }
            len++;
        }
        return len;
    }
}

class TrieNode{
    Map<Character,TrieNode> children = new HashMap<>();
}