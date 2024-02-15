class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        boolean[] res = new boolean[n];
        res[n - 1] = true;
        for(int i = n - 2; i >= 0; i--){
            int k = nums[i];
            
            while(k > 0){
                if(i + k < n && res[i + k] == true){
                    res[i] = true;
                    break;
                } 
                k--;
            }
        
        }
        
        return res[0];
    }
}