class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        subsetsBacktrack(0,nums,currList,res);
        return res;
    }

    private void subsetsBacktrack(
        int i, int[] nums, List<Integer> currList, List<List<Integer>> res) {
            if(i >= nums.length){
                res.add(List.copyOf(currList));
                return;
            }

            currList.add(nums[i]);
            subsetsBacktrack(i+1,nums,currList,res);

            currList.removeLast();
            subsetsBacktrack(i+1,nums,currList,res);
        }
}
