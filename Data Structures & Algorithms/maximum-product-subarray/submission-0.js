class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxProduct(nums) {
             if (nums.length === 1) return nums[0];     let maxProd = nums[0], currMinProd = nums[0], currMaxProd = nums[0];     for (let i = 1; i < nums.length; i++) {         const num = nums[i];         if (num < 0) [currMinProd, currMaxProd] = [currMaxProd, currMinProd];         currMinProd = Math.min(num, num * currMinProd);         currMaxProd = Math.max(num, num * currMaxProd);         maxProd = Math.max(maxProd, currMaxProd);     }     return maxProd;
    }
}
