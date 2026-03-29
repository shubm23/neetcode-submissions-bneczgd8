class Solution {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(s, p, 0, 0);
    }

    private boolean dp(String s, String p, int i, int j) {
        // Base case: pattern exhausted
        if (j == p.length()) return i == s.length();

        // Return cached result if available
        if (memo[i][j] != null) return memo[i][j];

        // Check if current characters match
        boolean firstMatch = i < s.length() &&
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        boolean result;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = dp(s, p, i, j + 2) ||              // zero occurrences
                     (firstMatch && dp(s, p, i + 1, j)); // one+ occurrences
        } else {
            result = firstMatch && dp(s, p, i + 1, j + 1);
        }

        return memo[i][j] = result;
    }
}