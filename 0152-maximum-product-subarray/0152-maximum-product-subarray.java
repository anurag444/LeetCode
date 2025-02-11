class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int leftprod = 1;
        int rightprod = 1;
        int max = nums[0];

        for(int i = 0; i < n; i++){
            leftprod = leftprod == 0 ? 1 : leftprod;
            rightprod = rightprod == 0 ? 1 : rightprod;

            leftprod *= nums[i];
            rightprod *= nums[n - 1- i];


            max = Math.max(max, Math.max(leftprod, rightprod));
        }

        return max; 
    }
}