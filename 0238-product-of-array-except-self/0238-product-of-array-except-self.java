class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int[] pref = new int[n + 1];
        int[] suff = new int[n + 1];


        pref[0] = 1;

        for(int i = 1; i <= n; i++){
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        suff[n] = 1;

        for(int i = n - 1; i >=0; i--){
            suff[i] = suff[i + 1] * nums[i];
        }

        for(int i = 0; i < n; i++){
            res[i] = pref[i] * suff[i + 1];
        }

        return res;
    }
}