class Solution {
    public int characterReplacement(String s, int k) {
        int longestRepeatChar = 0;
        int[] count = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            count[rightChar - 'A']++;
            int maxFreq = 0;
            for (int c : count) {
                maxFreq = Math.max(maxFreq, c);
            }
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l++);
                count[leftChar - 'A']--;
                for (int c : count) {
                    maxFreq = Math.max(maxFreq, c);
                }
            }
            longestRepeatChar = Math.max(longestRepeatChar, r - l + 1);
        }
        return longestRepeatChar;
    }
}
