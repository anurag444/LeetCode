class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int target = total / 2;
        if(total % 2 != 0) return false;
        
        return helperTab(nums, total);
    }
    
     public boolean helperTab(int[] nums, int total){
        Boolean[][] dp = new Boolean[nums.length + 1][total + 1];
        for(Boolean[] row : dp) Arrays.fill(row, false);

        for(int i = 0; i <= nums.length; i++) dp[i][0] = true;

        for(int index = nums.length - 1; index >= 0; index--){
            for(int target = 0; target <= total / 2; target++){
                boolean inc = false;
                if(target - nums[index] >= 0)
                    inc = dp[index + 1][target - nums[index]];
                
                boolean exc = dp[index + 1][target];

                dp[index][target] = (inc || exc);
            }
        }
        return dp[0][total / 2];
    }
}