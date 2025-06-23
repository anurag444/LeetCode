class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        int size = wordDict.size();
        Set<String> set = new HashSet<>();

        int max = 0;
        for(String str: wordDict){
            set.add(str);
            max = Math.max(max, str.length());
        }

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}