class Solution {
    public int countSubstrings(String s) {
        int count = 1;

        int n = s.length();

        for(int i = 1; i < n; i++){
            count++;
            int left = i - 1;
            int right = i + 1;
            int len = 1;

            while(left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    len += 2;
                    count++;
                }
                else{
                    break;
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
                count++;

                if(left == -1 || right == n) break;
            }
        }


        return count;
    }
}