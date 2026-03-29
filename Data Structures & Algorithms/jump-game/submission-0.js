class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    canJump(nums) {
      let goal = nums.length - 1;
      for(let i = nums.length - 1;i > -1;i--){
        if(goal <= (nums[i] + i)){
          goal = i;
        }
      }
      return goal === 0;
    }
}