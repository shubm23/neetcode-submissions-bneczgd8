class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    rob(nums) {
        return this.robRecursion(0,nums,{});
    }

    robRecursion(i,nums,memo){
        if(i >= nums.length) return 0;
        if(Object.hasOwn(memo,i)) return memo[i];
        memo[i] = Math.max(nums[i]+this.robRecursion(i + 2,nums,memo),this.robRecursion(i + 1,nums,memo));
        return memo[i];
    }
}