class Solution {
  /**
   * @param {number} n
   * @return {string[][]}
   */
  solveNQueens(n) {
    const res = [];
    const colSet = new Set();
    const posSet = new Set();
    const negSet = new Set();
    const board = Array.from({ length: n }, () => Array(n).fill("."));

    function backtrack(row) {
      if (row === n) {
        res.push(board.map((r) => r.join("")));
        return;
      }

      for(let col = 0; col < n;col++){
        if(colSet.has(col) || posSet.has(row + col) || negSet.has(row - col)){
          continue;
        }

        board[row][col] = "Q";
        posSet.add(row+col);
        negSet.add(row - col);
        colSet.add(col);

        backtrack(row + 1);
        
        board[row][col] = ".";
        posSet.delete(row+col);
        negSet.delete(row - col);
        colSet.delete(col);
      }
    }

    backtrack(0);

    return res;
  }
}