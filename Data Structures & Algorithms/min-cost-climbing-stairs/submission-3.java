class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();
    
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairsRec(cost.length - 1, cost), minCostClimbingStairsRec(cost.length - 2, cost));
    }

    private int minCostClimbingStairsRec(int i, int[] cost) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];
        if (map.containsKey(i)) return map.get(i);
        map.put(i, cost[i] + Math.min(minCostClimbingStairsRec(i - 1, cost), minCostClimbingStairsRec(i - 2, cost)));
        return map.get(i);
    }
}
