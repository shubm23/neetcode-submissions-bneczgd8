class Solution {
    /**
     * @param {number[]} cost
     * @return {number}
     */
    minCostClimbingStairs(cost) {
        const n = cost.length;
        const memo = new Map();
        return Math.min(this.minCost(n-1,cost,memo),this.minCost(n-2,cost,memo));
    }

    minCost(n,cost,memo){
        if(n < 0) return 0;
        if(n === 0 || n === 1) return cost[n];
        if(memo.has(n)) return memo.get(n);
        memo.set(n,cost[n] + Math.min(this.minCost(n-1,cost,memo),this.minCost(n-2,cost,memo)));
        return memo.get(n);
    }
}