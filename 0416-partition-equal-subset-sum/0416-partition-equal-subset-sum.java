class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int amount = 0;

        for(int val : nums){
            amount += val;
        }

        if(amount % 2 != 0) return false;
        amount /= 2;

        boolean[][] dp = new boolean[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]] ;
                }
            }
        }

        return dp[n][amount];
    }
}