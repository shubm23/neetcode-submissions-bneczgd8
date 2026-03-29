class Solution {
  /**
   * @param {number[][]} matrix
   * @return {number}
   */
  longestIncreasingPath(matrix) {
    const memo = new Map();
    const rows = matrix.length;
    const cols = matrix[0].length;

    const dfs = (i, j, prevValue) => {
      if (
        i < 0 ||
        j < 0 ||
        i === rows ||
        j === cols ||
        matrix[i][j] <= prevValue
      )
        return 0;
      const key = `${i}-${j}`;
      if (memo.has(key)) return memo.get(key);
      let res = 1;
      res = Math.max(res, 1 + dfs(i + 1, j, matrix[i][j]));
      res = Math.max(res, 1 + dfs(i - 1, j, matrix[i][j]));
      res = Math.max(res, 1 + dfs(i, j + 1, matrix[i][j]));
      res = Math.max(res, 1 + dfs(i, j - 1, matrix[i][j]));
      memo.set(key, res);
      return res;
    };

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        dfs(i, j, -1);
      }
    }
    return Math.max(...memo.values());
  }
}