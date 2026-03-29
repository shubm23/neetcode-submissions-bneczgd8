class Solution {
  /**
   * @param {number[]} nums
   * @param {number} target
   * @return {number}
   */
  findTargetSumWays(nums, target) {
    let ways = 0;
    const dfs = (i, currTarget) => {
      if (i >= nums.length) {
        if (currTarget === target) {
          ways++;
        }
        return;
      }

      dfs(i + 1, currTarget - nums[i]);
      dfs(i + 1, currTarget + nums[i]);
    };

    dfs(0,0);

    return ways;
  }
}