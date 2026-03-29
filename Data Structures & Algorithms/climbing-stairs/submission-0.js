class Solution {
    /**
     * @param {number} n
     * @return {number}
     */
    climbStairs(n , memo = {}) {
        if(n <= 1) return 1;
        if(Object.hasOwn(memo,n)) return memo[n];
        memo[n] = this.climbStairs(n-1,memo) + this.climbStairs(n-2,memo);
        return memo[n];
    }
}
