class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left, right;
        left = right = 0;
        int[] freq = new int[26];

        int max = 1;
        int maxFreq = 1;

        while(right < n){
            freq[s.charAt(right) - 'A']++;
            maxFreq = getMaxFreq(freq);
            if(maxFreq + k < right - left + 1){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            
            max = Math.max(right - left + 1, max);
            right++;
        }

        return max;
    }

    public int getMaxFreq(int[] freq){
        int max = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}