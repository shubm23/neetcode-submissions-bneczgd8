class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    permute(nums) {
      const result = [];
      function backtrack(path, remaining) {
        if (remaining.length === 0) {
          result.push([...path]);  // Save a copy of the current path
          return;
        }
        for (let i = 0; i < remaining.length; i++) {
          path.push(remaining[i]);  // Choose
          const newRemaining = remaining.slice(0, i).concat(remaining.slice(i + 1));
          backtrack(path, newRemaining);
          path.pop();
        }
      }
      backtrack([], nums);
      return result;
    }
}