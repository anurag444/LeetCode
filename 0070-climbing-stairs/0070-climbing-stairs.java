class Solution {
    public int climbStairs(int n) {
        int f = 1;
        int s = 2;

        if(n == 1) return 1;
        if(n == 2) return 2;

        int res = 0;

        for(int i = 3; i <= n; i++){
            res = f + s;
            f = s;
            s = res;
        }

        return res;
    }
}