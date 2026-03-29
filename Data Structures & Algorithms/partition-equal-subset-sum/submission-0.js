class Solution {
  /**
   * @param {number[]} nums
   * @return {boolean}
   */
  canPartition(nums) {
    const total = nums.reduce((a, c) => (a += c), 0);
    if (total % 2 !== 0) return false;
    const currentTarget = total / 2;
    const memo = new Map();

    function rec(i, currentSum = 0) {
      if (currentSum === 0) return true;
      if (i >= nums.length || currentSum < 0) return false;
      const key = `${i}-${currentSum}`;
      if (memo.has(key)) return memo.get(key);
      const solve = rec(i + 1, currentSum - nums[i]) || rec(i + 1, currentSum);
      memo.set(key, solve);
      return memo.get(key);
    }

    return rec(0, currentTarget);
  }
}