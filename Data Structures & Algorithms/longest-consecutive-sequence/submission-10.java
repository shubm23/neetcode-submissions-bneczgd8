class Solution {
    public int longestConsecutive(int[] nums) {
        int longstlen = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i] + 1))
                continue;
            int currLen = 1;
            int currNum = nums[i];
            while (numSet.contains(currNum - 1)) {
                currLen++;
                currNum--;
            }
            longstlen = Math.max(longstlen, currLen);
        }
        return longstlen;
    }
}
