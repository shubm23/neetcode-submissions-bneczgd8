class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return wordBreakDfs(0, s, wordDictSet, memo);
    }

    private boolean wordBreakDfs(int i, String s, Set<String> wordDict, Map<Integer, Boolean> memo) {
        if (i == s.length()) return true;
        if (memo.containsKey(i)) return memo.get(i);
        for (int j = i + 1; j <= s.length(); j++) {
            String prefix = s.substring(i, j);
            if (wordDict.contains(prefix) && wordBreakDfs(j, s, wordDict, memo)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
