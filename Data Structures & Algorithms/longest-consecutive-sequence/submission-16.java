class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) numsSet.add(num);
        for (int num : nums) {
            if (!numsSet.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while (numsSet.contains(currNum + 1)) {
                    currLen++;
                    currNum++;
                }
                longestLen = Math.max(currLen, longestLen);
            }
        }
        return longestLen;
    }
}