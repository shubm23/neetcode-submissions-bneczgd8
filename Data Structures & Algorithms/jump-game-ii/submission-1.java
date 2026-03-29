public class Solution {

    // 1. Initialize to a large value so Math.min works
    private int minCount = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        this.minCount = Integer.MAX_VALUE; // Reset for each call
        jumpDfs(0, nums, 0);
        return this.minCount;
    }

    private void jumpDfs(int i, int[] nums, int currCount) {
        // Base case: reached or passed the last index
        if (i >= nums.length - 1) {
            this.minCount = Math.min(this.minCount, currCount);
            return;
        }

        // Pruning: if we're already slower than the best path, give up
        if (currCount >= minCount) return;

        // 2. Loop through jump lengths, not indices
        // Try the largest jumps first to find the end faster
        for (int step = nums[i]; step >= 1; step--) {
            jumpDfs(i + step, nums, currCount + 1);
        }
    }
}