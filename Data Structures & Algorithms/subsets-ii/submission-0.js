class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    subsetsWithDup(nums) {
        const res = [],
        subset = [];

        nums.sort((a,b)=>a-b);

        (function dfs(i) {
        if (i >= nums.length) {
            res.push([...subset]); // Create a copy with spread operator
            return;
        }
        //Left Subtree
        subset.push(nums[i]);
        dfs(i + 1);
        //Right Subtree
        subset.pop();
        while(i+1<nums.length && nums[i] === nums[i+1]){
            i++;
        }
        dfs(i + 1);
        })(0);

        return [...res.values()];
    }
}
