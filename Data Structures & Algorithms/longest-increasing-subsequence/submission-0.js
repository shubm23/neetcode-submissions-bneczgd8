class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    lengthOfLIS(nums) {
        if (!nums.length) return 0;

        // tails[i] stores the smallest tail of all increasing subsequences of length i+1
        let tails = [];

        for (let x of nums) {
            let left = 0;
            let right = tails.length;

            // Binary search to find the insertion point for x
            while (left < right) {
                let mid = Math.floor((left + right) / 2);
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // If left is at the end, x is larger than all current tails
            if (left === tails.length) {
                tails.push(x);
            } else {
                // Otherwise, replace the existing tail with a smaller value (x)
                tails[left] = x;
            }
        }

        return tails.length;
    }
}