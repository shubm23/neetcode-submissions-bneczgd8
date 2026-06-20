class TrieNode {
    Map<Character, TrieNode> childrens;
    boolean isEnd;

    TrieNode() {
        childrens = new HashMap<>();
        isEnd = false;
    }
}

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.childrens.containsKey(ch)) {
                curr.childrens.put(ch, new TrieNode());
            }
            curr = curr.childrens.get(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(0, word, root);
    }

    private boolean search(int j, String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode node : curr.childrens.values()) {
                    if (search(i + 1, word, node))
                        return true;
                }
                return false;
            } else {
                if (!curr.childrens.containsKey(ch))
                    return false;
                curr = curr.childrens.get(ch);
            }
        }
        return curr.isEnd;
    }
}
