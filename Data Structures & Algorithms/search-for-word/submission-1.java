class Solution {
    public boolean exist(char[][] board, String word) {
        int wordLen = word.length();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backTrack(i, j, 0, wordLen, word, row, col, board))
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(
        int i, int j, int wordIdx, int wordLen, String word, int row, int col, char[][] board) {
        if (wordIdx == wordLen)
            return true;
        if (i >= row || j >= col || i < 0 || j < 0)
            return false;
        if (board[i][j] != word.charAt(wordIdx))
            return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = backTrack(i, j + 1, wordIdx + 1, wordLen, word, row, col, board)
            || backTrack(i + 1, j, wordIdx + 1, wordLen, word, row, col, board)
            || backTrack(i - 1, j, wordIdx + 1, wordLen, word, row, col, board)
            || backTrack(i, j - 1, wordIdx + 1, wordLen, word, row, col, board);
        board[i][j] = temp;
        return found;
    }
}
