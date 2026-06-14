class Solution {
    Set<Character> numsSet = Set.of('0', '1', '2', '3', '4', '5', '6');

    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>() {
            {
                put(s.length(), 1);
            }
        };
        return numDecodings(0, s, memo);
    }

    public int numDecodings(int i, String s, Map<Integer, Integer> memo) {
        if (memo.containsKey(i))
            return memo.get(i);
        if (s.charAt(i) == '0')
            return 0;
        int res = numDecodings(i + 1, s, memo);
        if (i + 1 < s.length()
            && (s.charAt(i) == '1' || (s.charAt(i) == '2' && numsSet.contains(s.charAt(i + 1))))) {
            res += numDecodings(i + 2, s, memo);
        }
        memo.put(i, res);
        return res;
    }
}
