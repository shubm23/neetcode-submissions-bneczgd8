class Solution {
  /**
   * @param {string} s
   * @return {number}
   */
  numDecodings(s) {
    const memo = {
      [s.length]: 1,
    };

    const dfs = (i) => {
      if (Object.hasOwn(memo, i)) return memo[i];
      if (s[i] === '0') return 0;

      let res = dfs(i + 1);

      if (
        i + 1 < s.length &&
        (s[i] === '1' ||
          (s[i] === '2' && ['0', '1', '2', '3', '4', '5', '6'].includes(s[i + 1])))
      ) {
        res += dfs(i + 2);
      }
      memo[i] = res;
      return res;
    };

    return dfs(0);
  }
}