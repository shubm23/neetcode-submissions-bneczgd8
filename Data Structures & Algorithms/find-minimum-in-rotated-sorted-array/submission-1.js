class Solution {
  /**
   * @param {number[]} nums
   * @return {number}
   */
  findMin(nums) {
    let res = Number.MAX_VALUE;
    let i = 0,
      j = nums.length - 1;

    while (i <= j) {
      if(nums[i] < nums[j]){
        res = Math.min(res,nums[i]);
        break;
      }
      const mid = Math.floor((i + j) / 2);
      res = Math.min(res,nums[mid]);
      if (nums[mid] >= nums[i]) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }

    return res;
  }
}
