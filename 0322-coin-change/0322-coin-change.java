class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        int m = coins.length;
        dp[0] = 0;
        for(int j = 1; j <= amount; j++){
           dp[j] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i] <= j && dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1); 
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}