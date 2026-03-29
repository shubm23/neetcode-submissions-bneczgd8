class Solution {
  /**
   * @param {number} m
   * @param {number} n
   * @return {number}
   */
  uniquePaths(m, n) {
    const memo = new Map();
    function dfs(i, j) {
      if (i >= m || j >= n) return 0;
      if (i === m - 1 && j === n - 1) return 1;
      const key = `${i}-${j}`;
      if (memo.has(key)) return memo.get(key);
      const down = dfs(i + 1, j);
      const right = dfs(i, j + 1);
      memo.set(key, right + down);
      return memo.get(key);
    }
    return dfs(0, 0);
  }
}
