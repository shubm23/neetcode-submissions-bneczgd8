

class Solution {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> memo = new HashMap<>();
        return minDistance(0, 0, word1, word2, memo);
    }

    private int minDistance(int i, int j, String word1, String word2, Map<String, Integer> memo) {
        if (word1.length() == i)
            return word2.length() - j;
        if (word2.length() == j)
            return word1.length() - i;
        String key = i + "-" + j;
        if (memo.containsKey(key))
            return memo.get(key);
        if (word1.charAt(i) == word2.charAt(j)) {
            memo.put(key, minDistance(i + 1, j + 1, word1, word2, memo));
        } else {
            memo.put(key,
                1
                    + Math.min(minDistance(i + 1, j + 1, word1, word2, memo),
                        Math.min(minDistance(i, j + 1, word1, word2, memo),
                            minDistance(i + 1, j, word1, word2, memo))));
        }
        return memo.get(key);
    }
}
