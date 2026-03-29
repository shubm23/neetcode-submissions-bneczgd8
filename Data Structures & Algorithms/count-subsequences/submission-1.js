class Solution {
  /**
   * @param {string} s
   * @param {string} t
   * @return {number}
   */
  numDistinct(s, t) {
    const memo = new Map();
    const dfs = (i, j) => {
      if (j === t.length) return 1;
      if (i === s.length) return 0;
      const key = i + '-' + j;
      if (memo.has(key)) return memo.get(key);
      if (s.charAt(i) === t.charAt(j)) {
        memo.set(key, dfs(i + 1, j + 1) + dfs(i + 1, j));
      } else {
        memo.set(key, dfs(i + 1, j));
      }
      return memo.get(key);
    };
    return dfs(0, 0);
  }
}