class Solution {
    public int characterReplacement(String s, int k) {
        int max= 0;
        
        int n = s.length();
        int left = 0;
        int[] freq = new int[26];
        int res = 0;
        
        for(int right = 0; right < n; right++){
            freq[s.charAt(right) - 'A']++;
            
            //checking the char with max ocuurance 
            max = Math.max(max, freq[s.charAt(right) - 'A']);
            
            //if the number char other max count is greater than k, then we will have to slide the window
            if(right - left + 1 - max > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}