class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int left = 1, right = 1;
        int max = nums[0];
        
        
        for(int i = 0; i < n; i++){
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;
            
            left *= nums[i];
            right *= nums[n - 1 - i];
            
            max = Math.max(max, Math.max(left, right));
        }
            
            return max;
        
    }
}