class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo  = new int[text1.length()][text2.length()];
        for(int[] m : memo){
            Arrays.fill(m,-1);
        }
        return longestCommonSubsequenceRec(0,0,memo,text1,text2);
    }

    private int longestCommonSubsequenceRec(int i,int j,int[][] memo,String text1,String text2){
        if(i == text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1+ longestCommonSubsequenceRec(i+1,j+1,memo,text1,text2);
        }else{
            memo[i][j] = Math.max(longestCommonSubsequenceRec(i,j+1,memo,text1,text2),longestCommonSubsequenceRec(i+1,j,memo,text1,text2));
        }

        return memo[i][j];
    }
}
