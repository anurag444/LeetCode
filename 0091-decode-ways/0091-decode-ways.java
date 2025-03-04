class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            char c = s.charAt(i - 1);

            
                dp[i] = dp[i - 1];

                if(c == '0'){

                    dp[i] = 0;
                }

                if(i > 1 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')){
                    dp[i] += dp[i - 2];
                }
            
        }

        return dp[n];
    }

    // public int ways(int i, String s){
    //     int n = s.length();

    //     if(i == n) return 1;
    //     if(s.charAt(i) == '0') return 0;

    //     int res = ways(i +1, s);

    //     if(i < n - 1 &&(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
    //         res += ways(i + 2, s);
    //     }

    //     return res;
    // }
}