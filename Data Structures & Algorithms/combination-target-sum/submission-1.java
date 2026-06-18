class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(0, nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int i, int[] nums, int currentTarget, int target,
        List<Integer> currList, List<List<Integer>> res) {
        if (currentTarget == target) {
            res.add(List.copyOf(currList));
            return;
        }

        if (i >= nums.length || currentTarget > target)
            return;

        for (int j = i; j < nums.length; j++) {
            currList.add(nums[j]);
            combinationSum(j, nums, currentTarget + nums[j], target, currList, res);
            currList.removeLast();
        }
    }
}
