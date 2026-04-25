class Solution {
    private Set<String> dict;
    private Map<Integer,Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return wordBreakRec(0,s);
    }

    private boolean wordBreakRec(int i,String s){
        if(i == s.length()) return true;
        if(memo.containsKey(i)) return memo.get(i);
        for (int j = i+1; j <= s.length(); j++) {
            String currStr = s.substring(i,j);
            if(dict.contains(currStr) && wordBreakRec(j,s)){
                memo.put(i,true);
                return true;
            }
        }
        memo.put(i,false);
        return false;
    }
}
