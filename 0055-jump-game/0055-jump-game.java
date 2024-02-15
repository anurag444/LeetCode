class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        
        //Better approach
        
        // set final index as end
        int end = n - 1;
        
        for(int i = n-2; i >= 0; i--){
            // if the value at curr index + the index is greater than end, then set end to current index
            if(i + nums[i] >= end){
                end = i;
            }
        }
        
        return end == 0;
        
//         boolean[] res = new boolean[n];
//         res[n - 1] = true;
//         for(int i = n - 2; i >= 0; i--){
//             int k = nums[i];
            
//             while(k > 0){
//                 if(i + k < n && res[i + k] == true){
//                     res[i] = true;
//                     break;
//                 } 
//                 k--;
//             }
        
//         }
        
//         return res[0];
    }
}