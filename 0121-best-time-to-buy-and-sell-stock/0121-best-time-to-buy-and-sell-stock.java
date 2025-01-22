class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int n = prices.length;
        int min = prices[0];

        for(int i = 1; i < n; i++){
            if(prices[i] - min > profit){
                profit = prices[i] - min;
            }else if(prices[i] < min){
                min = prices[i];
            }
        }

        return profit;

    }
}