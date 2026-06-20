class TrieNode {
    Map<Character, TrieNode> childrens;
    String word;

    TrieNode() {
        childrens = new HashMap<>();
        word = null;
    }
}

class Solution {
    private final TrieNode root = new TrieNode();
    private final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.childrens.containsKey(ch)) {
                curr.childrens.computeIfAbsent(ch, k -> new TrieNode());
            }
            curr = curr.childrens.get(ch);
        }
        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for (String word : words) addWord(word);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                findWords(i, j, board, root, res);
            }
        }

        return res;
    }

    private void findWords(int i, int j, char[][] board, TrieNode node, List<String> res) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols)
            return;
        char ch = board[i][j];
        if (ch == '#' || !node.childrens.containsKey(ch))
            return;
        TrieNode next = node.childrens.get(ch);
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';

        for (int[] dir : directions) {
            int row = dir[0] + i, col = dir[1] + j;
            findWords(row, col, board, next, res);
        }

        board[i][j] = ch;
    }
}