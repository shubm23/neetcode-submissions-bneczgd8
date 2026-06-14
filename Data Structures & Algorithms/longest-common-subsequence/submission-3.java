class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> memo = new HashMap<>();
        return longestCommonSubsequence(0, 0, text1, text2, memo);
    }

    private int longestCommonSubsequence(
        int i, int j, String text1, String text2, Map<String, Integer> memo) {
        if (i == text1.length() || j == text2.length())
            return 0;
        String key = i + "-" + j;
        if (memo.containsKey(key))
            return memo.get(key);
        if (text1.charAt(i) == text2.charAt(j)) {
            memo.put(key, 1 + longestCommonSubsequence(i + 1, j + 1, text1, text2, memo));
        } else {
            memo.put(key,
                Math.max(longestCommonSubsequence(i, j + 1, text1, text2, memo),
                    longestCommonSubsequence(i + 1, j, text1, text2, memo)));
        }
        return memo.get(key);
    }
}