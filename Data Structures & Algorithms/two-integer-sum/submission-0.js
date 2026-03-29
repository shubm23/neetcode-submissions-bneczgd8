class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const seen = new Map();
        for(const idx in nums){
            const diff = target - nums[idx];
            if(seen.has(diff)){
                return [Number(idx),Number(seen.get(diff))];
            }else{
                seen.set(nums[idx],idx);
            }
        }
        return [-1,-1];
    }
}
