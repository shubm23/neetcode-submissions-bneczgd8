class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxSubArray(nums) {
      let res = -Infinity;
      let total = 0;
      for(const num of nums){
        total += num;
        res = Math.max(res,total);
        if(total  < 0){
          total = 0;
        }
      }
      return res;
    }
}
