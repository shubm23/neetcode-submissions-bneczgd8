class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] m : memo){
            Arrays.fill(m,-1);
        }
        return dfs(0,0,memo,word1,word2);
    }

    private int dfs(int i,int j,int[][] memo,String s1,String s2){
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;

        if(memo[i][j] != -1) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dfs(i+1,j+1,memo,s1,s2);
        }else{
            memo[i][j] = 1 + Math.min(Math.min(dfs(i,j+1,memo,s1,s2),dfs(i+1,j,memo,s1,s2)),dfs(i+1,j+1,memo,s1,s2));
        }

        return memo[i][j];
    }
}
