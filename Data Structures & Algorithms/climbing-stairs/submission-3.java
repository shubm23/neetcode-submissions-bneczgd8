class Solution {
    private Map<Integer,Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
       if(n <= 1) return 1;
       if(memo.containsKey(n)) return memo.get(n);
       memo.put(n, climbStairs(n-1)+climbStairs(n-2));
       return memo.get(n);
    }
}
