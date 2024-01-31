class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front = new int[n];
        int[] back = new int[n];
        
        int max = 0;
        front[0] = prices[0];
        back[n - 1] = prices[n - 1];
        
        for(int i = 1; i < n; i++){
            front[i] = prices[i] < front[i - 1] ? prices[i] : front[i - 1];
        }
        
        for(int i = n - 2; i >= 0; i--){
            back[i] = prices[i] > back[i + 1] ? prices[i] : back[i + 1];
        }
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, (back[i] - front[i]));
        }
        
        return max;
    }
}