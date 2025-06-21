class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount + 1];

        //this is the base case, means to get amount 0 we need 0 coins
        dp[0] = 0;

        //initialize rest with MAX_VALUE

        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        //now iterate over the each of the elements 
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}