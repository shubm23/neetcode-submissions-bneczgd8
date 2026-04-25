class Solution {
     public int uniquePaths(int m, int n) {
        int[][] memo =  new int[m][n];
        for (int[] mm : memo){
            Arrays.fill(mm,-1);
        }
        return uniquePathsRec(0,0,m,n,memo);
    }

    private int uniquePathsRec(int i,int j,int m,int n,int[][] memo){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        var left = uniquePathsRec(i+1,j,m,n,memo);
        var right = uniquePathsRec(i,j+1,m,n,memo);
        memo[i][j] = left+ right;
        return memo[i][j];
    }
}
