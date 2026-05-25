class TrieNode{
    boolean isEndOfWord = false;
    TrieNode[] children = new TrieNode[26];
}
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return helper(0,word,root);
    }
    private boolean helper(int i,String word,TrieNode node){
        if(i==word.length() && node.isEndOfWord) return true;
        if(i==word.length()) return false;
        if(word.charAt(i)=='.'){
            for(int j=0; j<26; j++){
                if(node.children[j]!=null){
                    TrieNode tmp = node.children[j];
                    if(helper(i+1,word,tmp)) return true;
                }
            }
            return false;
        }else{
            char ch = word.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null) return false;
            node = node.children[index];
            return helper(i+1,word,node);
        }
    }

}
