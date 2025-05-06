class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] pref = new int[n + 1];
        int[] suff = new int[n + 1];

        pref[0] = 0;
        for(int i = 1; i <= n; i++){
            pref[i] = Math.max(pref[i - 1], height[i - 1]);
        }

        suff[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            suff[i] = Math.max(suff[i + 1], height[i]);
        }

        int sum = 0;
        for(int i = 0; i < n; i++){

            int temp = Math.min(pref[i], suff[i + 1]) - height[i];

            if(temp > 0){
                sum += temp;
            }
        }

        return sum;
    }
}