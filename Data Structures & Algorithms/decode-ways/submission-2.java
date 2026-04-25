class Solution {
    private Set<Character> set = Set.of('0','1','2','3','4','5','6');
    private Map<Integer,Integer> memo;

    public int numDecodings(String s) {
        memo = new HashMap<>(){{
           put(s.length(),1);
        }};
        return numDecodingsRecursion(0,s);
    }

    private int numDecodingsRecursion(int i,String s){
        if(memo.containsKey(i)) return memo.get(i);
        if(s.charAt(i) == '0') return 0;
        int res = numDecodingsRecursion(i+1,s);
        if(i+1< s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && set.contains(s.charAt(i+1))))){
            res += numDecodingsRecursion(i+2,s);
        }
        memo.put(i,res);
        return res;
    }
}
