class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zero = 0;

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zero++;
            else{
                prod *= nums[i];
            }
        }

        if(zero > 1){
            return res;
        }else if(zero == 1){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    res[i] = prod;
                }else{
                    res[i] = 0;
                }
            }
        }else{
            for(int i = 0; i < nums.length; i++){
                res[i] = prod/nums[i];
            }
        }

        return res;

    }
}