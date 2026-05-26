class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    subsets(nums) {
      const res = [] , subset = [];

      (function dfs(i){
        if(i >= nums.length){
          res.push([...subset]);
          return;
        }
        //Left Subtree
        subset.push(nums[i]);
        dfs(i+1);
        //Right Subtree
        subset.pop();
        dfs(i+1);
      })(0, [])

      return res;
    }
}