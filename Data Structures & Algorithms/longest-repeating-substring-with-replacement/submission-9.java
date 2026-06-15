class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, longestLen = 0;
        int[] count = new int[26];
        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            count[rChar - 'A']++;
            int max = 0;
            for (int c : count) {
                max = Math.max(c, max);
            }
            while (r - l + 1 - max > k) {
                char lChar = s.charAt(l++);
                count[lChar - 'A']--;
                for (int c : count) {
                    max = Math.max(c, max);
                }
            }

            longestLen = Math.max(longestLen, r - l + 1);
        }
        return longestLen;
    }
}
