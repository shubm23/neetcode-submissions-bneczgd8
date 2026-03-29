class Solution {
  /**
   * @param {character[][]} board
   * @param {string} word
   * @return {boolean}
   */
  exist(board, word) {
    const wordStack = word.split('');
    const rows = board.length;
    const cols = board[0].length;

    function backtrack(i, j, wordIdx) {
      if (wordIdx === wordStack.length) return true;
      if (i < 0 || j < 0 || i >= rows || j >= cols) return false;
      if (wordStack[wordIdx] !== board[i][j]) return false;
      const temp = board[i][j];
      board[i][j] = '#';
      const found =
        backtrack(i + 1, j, wordIdx + 1) ||
        backtrack(i - 1, j, wordIdx + 1) ||
        backtrack(i, j - 1, wordIdx + 1) ||
        backtrack(i, j + 1, wordIdx + 1);

      board[i][j] = temp;
      return found;
    }

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        if (backtrack(i, j, 0)) return true;
      }
    }

    return false;
  }
}