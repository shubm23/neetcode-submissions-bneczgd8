class Solution {
  /**
   * @param {number[]} nums
   * @return {number}
   */
  rob(nums) {
    if (nums.length === 0) return 0;
    if (nums.length === 1) return nums[0];
    const rob1 = this.robRecursion(0, nums.slice(0, nums.length - 1), {});
    const rob2 = this.robRecursion(0, nums.slice(1, nums.length), {});
    return Math.max(rob1, rob2);
  }

  robRecursion(i, nums, memo) {
    if (i >= nums.length) return 0;
    if (Object.hasOwn(memo, i)) return memo[i];
    memo[i] = Math.max(
      nums[i] + this.robRecursion(i + 2, nums, memo),
      this.robRecursion(i + 1, nums, memo),
    );
    return memo[i];
  }
}