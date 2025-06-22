class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int n = s.length();

        int i = 0;
        int ans = 0;
        int maxFreq = 0;
        for(int j = 0; j < n; j++){
            freq[s.charAt(j) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            if((j - i + 1) > maxFreq + k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}