class TrieNode {
    Map<Character, TrieNode> children;
    boolean endPoint;

    public TrieNode() {
        children = new HashMap<>();
        endPoint = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() { root = new TrieNode(); }

    public void insert(String word) {
        var curr = root;
        for (char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.endPoint = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        List<String> res = new ArrayList<>();
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                dfs(board, i, j, trie.root, visited, res, sb);

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node,
                     boolean[][] visited, List<String> res, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j]) return;

        TrieNode next = node.children.get(board[i][j]);
        if (next == null) return;

        visited[i][j] = true;
        sb.append(board[i][j]);

        if (next.endPoint) {
            res.add(sb.toString());
            next.endPoint = false; // avoid duplicates
        }

        dfs(board, i - 1, j, next, visited, res, sb);
        dfs(board, i + 1, j, next, visited, res, sb);
        dfs(board, i, j - 1, next, visited, res, sb);
        dfs(board, i, j + 1, next, visited, res, sb);

        sb.deleteCharAt(sb.length() - 1); // backtrack
        visited[i][j] = false;

        // Prune exhausted branches — this is what fixes TLE
        if (!next.endPoint && next.children.isEmpty()) {
            node.children.remove(board[i][j]);
        }
    }
}