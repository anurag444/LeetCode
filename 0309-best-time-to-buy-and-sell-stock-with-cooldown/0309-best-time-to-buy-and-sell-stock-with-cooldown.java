class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        return maxProfitHelperTab(prices, n);
        
    }
    
    //Tabulation approach 
    private int maxProfitHelperTab(int[] prices, int n){
        int[][] dp = new int[n + 2][2];
        
        
        for(int index = n - 1; index >= 0; index--){
            int profit = 0;
            for(int buy = 0; buy <=1; buy++){
                if(buy == 1){
                    profit = Math.max(-prices[index] + dp[index + 1][0],
                             0 + dp[index + 1][1]);
                }
                else{
                    profit = Math.max(prices[index] + dp[index + 2][1],
                             0 + dp[index + 1][0]);
                }
                
                dp[index][buy] = profit;
            }
            
        }
        
        
        return dp[0][1];
    }
    
    
}