class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        int max = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        
                        if(dp[i] > max){
                            max = dp[i];
                        }
                    }
                }
            }
        }
        
        
        return max + 1;
    }
}