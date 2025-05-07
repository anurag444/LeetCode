class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        long sum = 0;
        for(int i = 0, j = 0; i < n; ++i){
            sum += nums[i];
            while(sum + k < (long) nums[i] * (i - j + 1)){
                sum -= nums[j];
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}