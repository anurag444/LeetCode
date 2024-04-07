class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        
        int l = 0;
        int r = n - 1;
        int min = nums[0];
        
        while(l < r){
            int m = (l + r)/2;
            
            if(nums[m] > nums[r]){
                l = m + 1;
            }else{
                r = m;
            }
            
            min = Math.min(min, nums[l]);
        }
        
        
        return min;
    }
}