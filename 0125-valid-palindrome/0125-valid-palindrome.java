class Solution {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "");

        result = result.toLowerCase();

        int l = 0, h = result.length() - 1;

        while(l < h){
            if(result.charAt(l) != result.charAt(h))
                return false;
            
            l++;
            h--;
        }

        return true;
    }
}