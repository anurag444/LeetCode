class Solution {
    
    //HashSet Solution
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        
        boolean[] dp = new boolean[n + 1];
        
        //Set the starting point as true
        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                //check if substring exists in the set and starting point is true means we have successfull word break till that point
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    
    
    //We can do same approach by starting from end and repeatin gt he same process
}