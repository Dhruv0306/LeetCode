class WordNode {
    WordNode[] children = new WordNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    private final WordNode root;

    public WordDictionary() {
        root = new WordNode();
    }

    public void addWord(String word) {
        WordNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new WordNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, WordNode curr) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (WordNode child : curr.children) {
                if (child != null && dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int letterIndex = ch - 'a';
            WordNode child = curr.children[letterIndex];
            if (child == null) {
                return false;
            }
            return dfsSearch(word, index + 1, child);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */