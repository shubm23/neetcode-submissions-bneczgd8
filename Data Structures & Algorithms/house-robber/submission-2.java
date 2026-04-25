class Solution {
    private Map<Integer,Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return robRec(nums,0);
    }

    private int robRec(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        memo.put(i, Math.max(nums[i]+robRec(nums,i+2),robRec(nums,i+1)));
        return memo.get(i);
    }
}
