class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
      const n = nums.length;
      const res = new Array(n).fill(1);

      let prefixProduct = 1;
      for(let i = 0;i < n;i++){
        res[i] = prefixProduct;
        prefixProduct *= nums[i];
      }

      console.log({res})

      let suffixProduct = 1;
      for(let i = n-1;i >=0;i--){
        res[i] *= suffixProduct;
        suffixProduct *= nums[i];
      }

      return res;
    }
}