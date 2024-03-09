class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
                
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        int curr = dp[1];
        int prev = dp[0];
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(cost[i] + prev, curr + cost[i]);
            prev = curr;
            curr = dp[i];
        }
        
        return Math.min(prev, curr);
    }
}