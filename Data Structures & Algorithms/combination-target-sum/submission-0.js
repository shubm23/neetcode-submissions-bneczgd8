class Solution {
    combinationSum(nums, target) {
      const res = [];
      
      function backtrack(index, currentPath, currentSum) {
        if (currentSum === target) {
          res.push([...currentPath]);
          return;
        }
        
        if (currentSum > target) return;
        
        for (let i = index; i < nums.length; i++) {
          currentPath.push(nums[i]);  // ✅ This is correct
          backtrack(i, currentPath, currentSum + nums[i]);
          currentPath.pop();
        }
      }
      
      backtrack(0, [], 0);
      return res;
    }
}