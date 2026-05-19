
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        return wordBreakDfs(0, s, wordDictSet, new HashMap<>());
    }

    private boolean wordBreakDfs(
        int i, String s, Set<String> wordDictSet, Map<Integer, Boolean> memo) {
        if (i == s.length())
            return true;
        if (memo.containsKey(i))
            return memo.get(i);
        for (int j = i; j <= s.length(); j++) {
            String subStr = s.substring(i, j);
            if (wordDictSet.contains(subStr) && wordBreakDfs(j, s, wordDictSet, memo)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}