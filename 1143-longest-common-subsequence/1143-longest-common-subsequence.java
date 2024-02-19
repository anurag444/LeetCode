class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(text2.charAt(i) == text1.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        
        return dp[m][n];
    }
}