class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num + 1)) continue;
            int curLen = 1;
            int curNum = num;
            while (set.contains(curNum - 1)) {
                curLen++;
                curNum--;
            }
            longestLen = Math.max(longestLen, curLen);
        }

        return longestLen;
    }
}
