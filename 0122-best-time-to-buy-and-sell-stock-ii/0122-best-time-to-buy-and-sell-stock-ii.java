class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        return maxProfitHelperTab(prices, n);
        
        
        //return maxProfitHelperMem(0, 1, prices, n, dp);
    }
    
    
    //Memoozimation approach 
    private int maxProfitHelperMem(int index, int buy, int[] prices, int n, int[][] dp){
        if(index == n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfitHelperMem(index + 1, 0, prices, n, dp),
                             0 + maxProfitHelperMem(index + 1, 1, prices, n, dp));
        }
        else{
            profit = Math.max(prices[index] + maxProfitHelperMem(index + 1, 1, prices, n, dp),
                             0 + maxProfitHelperMem(index + 1, 0, prices, n, dp));
        }
        
        dp[index][buy] = profit;
        
        return profit;
    }
    
    //Tabulation approach 
    private int maxProfitHelperTab(int[] prices, int n){
        int[][] dp = new int[n + 1][2];
        
        
        for(int index = n - 1; index >= 0; index--){
            int profit = 0;
            for(int buy = 0; buy <=1; buy++){
                if(buy == 1){
                    profit = Math.max(-prices[index] + dp[index + 1][0],
                             0 + dp[index + 1][1]);
                }
                else{
                    profit = Math.max(prices[index] + dp[index + 1][1],
                             0 + dp[index + 1][0]);
                }
                
                dp[index][buy] = profit;
            }
            
        }
        
        
        return dp[0][1];
    }
}