class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        int max = 1;

        int n = s.length();

        for(int i = 1; i < n; i++){

            int left = i - 1;
            int right = i + 1;
            int len = 1;

            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    len += 2;
                }
                else{
                    break;
                }

                if(len > max){
                    max = len;
                    res = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            left = i - 1;
            right = i;


            //even len
            while(s.charAt(left) == s.charAt(right)){
                left--;
                right++;

                if(left == -1 || right == n) break;
            }

            String str = s.substring(left + 1, right);

            if(str.length() > max){
                res = str;
                max = str.length();
            }
        }


        return res;
    }
}