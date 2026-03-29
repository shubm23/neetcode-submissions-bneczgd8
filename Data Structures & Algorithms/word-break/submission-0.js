class Solution {
  /**
   * @param {string} s
   * @param {string[]} wordDict
   * @return {boolean}
   */
  wordBreak(s, wordDict) {
    const wordDictSet = new Set([...wordDict]);
    const memo = new Map();

    function dfs(i, s, wordDictSet = new Set(), memo = new Map()) {
      if (i === s.length) return true;
      if (memo.has(i)) return memo.get(i);

      for (let j = i + 1; j <= s.length; j++) {
        const prefix = s.substring(i, j);
        if (wordDictSet.has(prefix) && dfs(j, s, wordDictSet, memo)) {
          memo.set(i, true);
          return true;
        }
      }

      memo.set(i, false);
      return false;
    }

    return dfs(0, s, wordDictSet, memo);
  }
}