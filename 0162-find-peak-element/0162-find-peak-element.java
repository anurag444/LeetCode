class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return 0;
        
        if(nums[0] > nums[1]) return 0;
        
        if(nums[n-1] > nums[n-2]) return n - 1;
        
        
        int l = 0;
        int h = n - 1;
        
        int mid = 0;
        
        while(l < h){
            mid = (l + h)/2;
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            
            else if(nums[mid] > nums[mid - 1]) l = mid + 1;
            
            else h = mid;
        }
        
        return mid;
    }
}