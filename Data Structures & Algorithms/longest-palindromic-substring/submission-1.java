class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startIdx = 0;
        for(int i = 0;i < s.length();i++){
            int len1 = expandFromCenter(i,i,s);
            int len2 = expandFromCenter(i,i+1,s);
            int len = Math.max(len1,len2);
            if(maxLen < len){
                maxLen = len;
                startIdx = i - (len - 1)/2;
            }
        }
        return s.substring(startIdx,startIdx+maxLen);
    }

    private int expandFromCenter(int i,int j,String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return j - i - 1;
    }
}
