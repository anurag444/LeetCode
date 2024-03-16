class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    
        return helper(nums,0,target,0);
    }
    private int helper(int[] nums,int ans,int target,int index){
        if(index == nums.length && ans != target) return 0;
        if(index == nums.length && ans == target){
            return 1;
        }
       int left = helper(nums,ans + nums[index],target,index+1);
       int right = helper(nums,ans - nums[index],target,index+1);
       return left+right;

    }
}