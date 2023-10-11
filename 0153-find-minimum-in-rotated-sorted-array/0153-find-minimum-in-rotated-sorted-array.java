class Solution {
    public int findMin(int[] nums) {
        int si=0;
        int ei = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(si<=ei){
            int mid = si+(ei-si)/2;
        if(nums[si]<=nums[mid]){
            ans = Math.min(ans,nums[si]);
            si = mid+1;
        }
        else{
            ans = Math.min(ans, nums[mid]);
            ei = mid-1;
        }
                
        }

        return ans;
    }
    
}