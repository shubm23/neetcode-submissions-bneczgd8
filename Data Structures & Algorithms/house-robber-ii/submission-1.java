class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int rob1 = robRec(Arrays.copyOfRange(nums,0,nums.length-1),0,new HashMap<>());
        int rob2  = robRec(Arrays.copyOfRange(nums,1,nums.length),0,new HashMap<>());
        return Math.max(rob1,rob2);
    }

    private int robRec(int[] nums, int i, Map<Integer,Integer> memo){
        if(i >= nums.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        memo.put(i, Math.max(nums[i]+robRec(nums,i+2,memo),robRec(nums,i+1,memo)));
        return memo.get(i);
    }
}
