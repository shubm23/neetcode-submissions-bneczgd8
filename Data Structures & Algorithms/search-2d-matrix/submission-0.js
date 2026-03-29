class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    search(nums, target) {
        let i = 0, j = nums.length - 1;
        while(i <= j){
            const mid = Math.floor((i+j)/2);
            if(nums[mid] === target) return mid;
            if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return -1;
    }
    searchMatrix(matrix, target) {
        const n = matrix.length;
        for(let i = 0;i < n;i++){
            const status = this.search(matrix[i],target);
            if(status !== -1) return true;
        }
        return false;
    }
}
