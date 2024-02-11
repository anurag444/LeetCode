class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] = digits[n - 1] + 1;
        int carry = 0;
        
        for(int i = n - 1; i >= 0; i--){
            digits[i] = digits[i] + carry;
            if(digits[i] > 9){
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }else{
                carry = 0;
            }
        }
        
        if(carry != 0){
            int[] res = new int[n + 1];
            res[0] = carry;
            for(int i = 0; i < n; i++){
                res[i + 1] = digits[i];
                
                return res;
            }
        }
        
        
        
        return digits;
    }
}