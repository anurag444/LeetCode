class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suff = new int[n];

        suff[n - 1] = prices[n - 1];

        for(int i = n - 2; i >= 0; i--){
            suff[i] = Math.max(suff[i + 1], prices[i]);
        }

        int ans =0;
        for(int i = 0; i < n - 1; i++){
            ans = Math.max(ans, suff[i + 1] - prices[i]);
        }

        return ans;
    }
}