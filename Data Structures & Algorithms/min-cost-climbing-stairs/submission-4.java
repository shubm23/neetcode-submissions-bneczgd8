class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(minCostClimbingStairsRec(cost.length - 1, cost, memo),
            minCostClimbingStairsRec(cost.length - 2, cost, memo));
    }

    public int minCostClimbingStairsRec(int i, int[] cost, Map<Integer, Integer> memo) {
        if (i < 0)
            return 0;
        if (i == 0 || i == 1)
            return cost[i];
        if (memo.containsKey(i))
            return memo.get(i);
        memo.put(i,
            cost[i]
                + Math.min(minCostClimbingStairsRec(i - 1, cost, memo),
                    minCostClimbingStairsRec(i - 2, cost, memo)));
        return memo.get(i);
    }
}
