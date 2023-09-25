class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;

        while(i < j){
            while(i < n && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j > 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if(i < j){
                char c = s.charAt(i);
                char d = s.charAt(j);
                if(Character.toLowerCase(c) != Character.toLowerCase(d)) return false;
            }

            i++;
            j--;

        }

        return true;
    
    }
}