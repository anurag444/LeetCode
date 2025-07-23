class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        int n = s.length();
        String res = s.substring(0, 1);

        for(int i = 1; i < n; i++){
            //odd

            left = i -1;
            right = i + 1;

            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            left++;
            right--;

            if(res.length() < right - left + 1){
                res = s.substring(left, right + 1);
            }


            //even length;
            left = i -1;
            right = i;
            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }

            left++;
            right--;

            if(res.length() < right - left + 1){
                res = s.substring(left, right + 1);
            }

        }

        return res;
    }
}