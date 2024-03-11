class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n][2];
        
        for (int[] row: dp)
            Arrays.fill(row, -1);
        
        return maxProfitHelper(0, 1, prices, n, dp);
    }
    
    private int maxProfitHelper(int index, int buy, int[] prices, int n, int[][] dp){
        if(index == n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfitHelper(index + 1, 0, prices, n, dp),
                             0 + maxProfitHelper(index + 1, 1, prices, n, dp));
        }
        else{
            profit = Math.max(prices[index] + maxProfitHelper(index + 1, 1, prices, n, dp),
                             0 + maxProfitHelper(index + 1, 0, prices, n, dp));
        }
        
        dp[index][buy] = profit;
        
        return profit;
    }
}