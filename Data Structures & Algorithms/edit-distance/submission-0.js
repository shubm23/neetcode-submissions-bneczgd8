class Solution {
  /**
   * @param {string} word1
   * @param {string} word2
   * @return {number}
   */
  minDistance(word1, word2) {
    const memo = new Map();
    const dfs = (i, j) => {
      if (i === word1.length) return word2.length - j;
      if (j === word2.length) return word1.length - i;
      const key = `${i}-${j}`;
      if (memo.has(key)) return memo.get(key);
      if (word1.charAt(i) === word2.charAt(j)) {
        memo.set(key, dfs(i + 1, j + 1));
      } else {
        memo.set(
          key,
          Math.min(1 + dfs(i + 1, j), 1 + dfs(i, j + 1), 1 + dfs(i + 1, j + 1)),
        );
      }
      return memo.get(key);
    };
    return dfs(0, 0);
  }
}