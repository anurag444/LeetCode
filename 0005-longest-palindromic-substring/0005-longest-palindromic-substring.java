class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String res = "";

        for(int i = 1; i < n; i++){
            //odd len
            int left = i - 1;
            int right = i + 1;
            int len = 1;

            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    len = len + 2;

                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            left++;
            right--;

            if(right - left + 1> max){
                max = right - left + 1;
                res = s.substring(left, right + 1);
            }


            //even len
            left = i - 1;
            right = i;
            len = 0;

            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    len = len + 2;

                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            left++;
            right--;

            if(right - left + 1> max){
                max = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }

        return res;
    }
}