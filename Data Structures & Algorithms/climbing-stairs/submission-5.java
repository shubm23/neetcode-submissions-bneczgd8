class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        return climbStairsRec(n);
    }

    private int climbStairsRec(int n) {
        if (n <= 1)
            return 1;
        if (memo.containsKey(n))
            return memo.get(n);
        memo.put(n, climbStairsRec(n - 1) + climbStairsRec(n - 2));
        return memo.get(n);
    }
}
