class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zero = 0;


        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zero++;
            else{
                prod *= nums[i];
            }
        }

        if(zero > 1){
            for(int i = 0; i < nums.length; i++){
                nums[i] = 0;
            }
        }else if(zero == 1){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    nums[i] = prod;
                }else{
                    nums[i] = 0;
                }
            }
        }else{
            for(int i = 0; i < nums.length; i++){
                nums[i] = prod/nums[i];
            }
        }

        return nums;

    }
}