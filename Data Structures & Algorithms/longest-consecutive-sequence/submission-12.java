class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) numsSet.add(num);

        for (int num : nums) {
            // Check if 'num' is the START of a sequence
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // Count how far the sequence goes forward
                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }

                longestLen = Math.max(longestLen, currentLen);
            }
        }
        return longestLen;
    }
}