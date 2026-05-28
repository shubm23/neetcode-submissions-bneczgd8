class Solution {
    public int climbStairs(int n) {
        return climbStairsRec(n, new HashMap<>());
    }

    private int climbStairsRec(int n, Map<Integer, Integer> memo) {
        if (n <= 1)
            return 1;
        if (memo.containsKey(n))
            return memo.get(n);
        memo.put(n, climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo));
        return memo.get(n);
    }
}
