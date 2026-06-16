class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        return canPartition(0, target, nums);
    }

    public boolean canPartition(int i, int target, int[] nums) {
        if (target == 0)
            return true;
        if (i >= nums.length || target < 0)
            return false;
        String key = i + "-" + target;
        if (memo.containsKey(key))
            return memo.get(key);
        boolean solve =
            canPartition(i + 1, target - nums[i], nums) || canPartition(i + 1, target, nums);
        memo.put(key, solve);
        return memo.get(key);
    }
}
