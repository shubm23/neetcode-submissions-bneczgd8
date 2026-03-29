class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums, k) {
        const dequeue = [], res = [];
        
        for(let i = 0;i < nums.length;i++){
            while (dequeue.length > 0 && dequeue[0] < i - k + 1) {
            dequeue.shift();
        }
            
            while(dequeue.length > 0 && nums[i] > nums[dequeue[dequeue.length - 1]]){
                dequeue.pop();
            }
            
            dequeue.push(i);
            
            if(i >= k - 1){
                res.push(nums[dequeue[0]]);
            }
        }
        
        return res;
    }
}