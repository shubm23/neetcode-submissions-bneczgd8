class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : memo) {
            max = Math.max(num, max);
        }

        return max;
    }
}
