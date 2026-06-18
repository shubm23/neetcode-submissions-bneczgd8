class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void subsets(int i, int[] nums, List<Integer> currList, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(List.copyOf(currList));
            return;
        }
        currList.add(nums[i]);
        subsets(i + 1, nums, currList, res);

        currList.removeLast();
        subsets(i + 1, nums, currList, res);
    }
}
