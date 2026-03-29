class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
         const seen = new Map();
  for (const num of nums) {
      seen.set(num, (seen.get(num) || 0) + 1);
  }
  return [...seen.entries()].sort((a,b)=>b[1]-a[1]).map(el => el[0]).splice(0,k);
    }
}
