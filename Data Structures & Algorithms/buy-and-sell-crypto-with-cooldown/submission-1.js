class Solution {
  /**
   * @param {number[]} prices
   * @return {number}
   */
  maxProfit(prices) {
    const memo = new Map();

    function dfs(i, buying) {
      if (i >= prices.length) return 0;
      const key = `${i}-${buying}`;
      if (memo.has(key)) return memo.get(key);
      const cooldown = dfs(i + 1, buying);
      if (buying) {
        const buy = dfs(i + 1, !buying) - prices[i];
        memo.set(key, Math.max(buy, cooldown));
      } else {
        const sell = dfs(i + 2, !buying) + prices[i];
        memo.set(key, Math.max(sell, cooldown));
      }
      return memo.get(key);
    }

    return dfs(0, true);
  }
}