class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] ways = new int[n + 1];

        ways[0] = 1;

        if(s.charAt(0) == '0') return 0;

        ways[1] = 1;

        for(int i = 1; i < n; i++){
            int num = Character.getNumericValue(s.charAt(i));

            //check if single digit is valid
            if(num > 0 && num <= 26){
                ways[i + 1] = ways[i];
            }

            //check if double digit is valid
            int num1 = Character.getNumericValue(s.charAt(i - 1));

            if(num1 == 0) continue;

            num1 = num1 * 10 + num;

            if(num1 > 0 && num1 <= 26){
                ways[i + 1] += ways[i - 1];
            }
        }

        return ways[n];
    }
}