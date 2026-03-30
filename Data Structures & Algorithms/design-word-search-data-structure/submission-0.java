class Trie {
    private class TrieNode {
        boolean end = false;
        Map<Character, TrieNode> childrens;

        TrieNode() {
            childrens = new HashMap<>();
        }
    }

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentNode = root;
        for(char c: word.toCharArray()) {
            currentNode.childrens.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.childrens.get(c);
        }
        currentNode.end = true;
    }

    private boolean search(String word, TrieNode node, int index) {
        if(index == word.length()) return node.end;

        char curr = word.charAt(index); 
        if(curr =='.') {
            for(char c: node.childrens.keySet()) {
                if(search(word, node.childrens.get(c), index+1))
                    return true;
            }
        } else if (node.childrens.containsKey(curr)) {
            return search(word, node.childrens.get(curr), index+1);
        }
        return false;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }
}

class WordDictionary {
    Trie trie = new Trie();
    public WordDictionary() {

    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
