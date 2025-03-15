class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0 || n == 0) return 0;

        int[][] dp = new int[m][n];
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int len = dfs(i, j, matrix, dp, Integer.MIN_VALUE);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] dp, int pre){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) return 0;

        if(dp[i][j] > 0) return dp[i][j];
        else {
            int temp = 0;

            temp = Math.max(dfs(i + 1, j, matrix, dp, matrix[i][j]), temp);
            temp = Math.max(dfs(i - 1, j, matrix, dp, matrix[i][j]), temp);
            temp = Math.max(dfs(i, j + 1, matrix, dp, matrix[i][j]), temp);
            temp = Math.max(dfs(i, j - 1, matrix, dp, matrix[i][j]), temp);
            dp[i][j] = ++temp;

            return temp;
        }
    }
}