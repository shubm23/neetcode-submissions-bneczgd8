class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];

        Arrays.fill(memo, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
        }

        int max = 0;
        for (int val : memo) {
            max = Math.max(max, val);
        }

        return max;
    }
}