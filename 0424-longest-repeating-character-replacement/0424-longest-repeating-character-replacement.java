class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(freq[s.charAt(right) - 'A'], maxFreq);

            int window = right - left + 1;

            if(window - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            window = right - left + 1;
            maxWindow = Math.max(window, maxWindow);
        }


        return maxWindow;
    }
}