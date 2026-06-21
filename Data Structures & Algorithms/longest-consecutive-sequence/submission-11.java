class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) numsSet.add(num);
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i] + 1))
                continue;
            int len = 1;
            while (numsSet.contains(nums[i] - 1)) {
                nums[i]--;
                len++;
            }
            longestLen = Math.max(longestLen, len);
        }
        return longestLen;
    }
}
