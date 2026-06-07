//Input: nums = [-1,0,1,2,-1,-4]

class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    threeSum(nums) {
        const res = [];
        nums.sort((a,b)=>a-b);
        for(let i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i - 1] === nums[i]) continue;
            if(nums[i] > 0) break;
            let l = i + 1, r = nums.length - 1;
            while(l < r){
                const sum = nums[i] + nums[l] + nums[r];
                if(sum === 0){
                    res.push([nums[i],nums[l],nums[r]]);
                    while(l < r && nums[l] === nums[l+1]){
                        l++;
                    }
                    while(l < r && nums[r - 1] === nums[r]){
                        r--;
                    }
                    
                    l++;
                    r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        
        return res;
    }
}
