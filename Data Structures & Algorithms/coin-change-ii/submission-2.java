class Solution {
    public int change(int amount, int[] coins) {
        return changeDfs(0, 0, amount, coins, new HashMap<>());
    }

    private int changeDfs(int i, int a, int amount, int[] coins, Map<String, Integer> memo) {
        if (a == amount) return 1;
        if (a > amount) return 0;
        if (i == coins.length) return 0;
        String key = i + "" + a;
        if (memo.containsKey(key)) return memo.get(key);
        memo.put(key, changeDfs(i, coins[i] + a, amount, coins, memo) + changeDfs(i + 1, a, amount, coins, memo));
        return memo.get(key);
    }
}
