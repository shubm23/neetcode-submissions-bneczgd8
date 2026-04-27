class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, longestSub = 0;
        int[] count = new int[26];

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;

            int maxFreq = 0;
            for (int c : count) {
                maxFreq = Math.max(maxFreq, c);
            }

            while (r - l + 1 - maxFreq > k) {
                count[s.charAt(l++) - 'A']--;
                maxFreq = 0;
                for (int c : count) {
                    maxFreq = Math.max(maxFreq, c);
                }
            }

            longestSub = Math.max(longestSub, r - l + 1);
        }

        return longestSub;
    }
}