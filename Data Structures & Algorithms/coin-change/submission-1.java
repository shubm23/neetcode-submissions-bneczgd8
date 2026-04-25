class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return minCoins(coins, amount, memo);
    }

    private int minCoins(int[] coins, int remaining, int[] memo) {
        if (remaining == 0) return 0;
        if (remaining < 0) return -1;

        if (memo[remaining] != Integer.MIN_VALUE) {
            return memo[remaining];
        }

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = minCoins(coins, remaining - coin, memo);
            if (result >= 0) {
                minCount = Math.min(minCount, result + 1);
            }
        }

        memo[remaining] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return memo[remaining];
    }
}