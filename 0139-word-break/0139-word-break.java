class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //store the dict in set

        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        //find max len of dict word
        for(String word : dict){
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = i -1; j >= Math.max(0, i - maxLen); j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}