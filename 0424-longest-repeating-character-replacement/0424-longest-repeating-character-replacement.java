class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int left = 0;
        int right = 0;
        int ans = 0;
        int maxFreq = 0;


        int[] freq = new int[26];

        while(right < n){
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = getMaxFreq(freq);

            if(maxFreq + k < right - left + 1){
            
                freq[s.charAt(left) - 'A']--;
                left++;
            }else{
                ans = Math.max(ans, right - left + 1);
            }
            
            right++;
        }

        return ans;
    }

    public int getMaxFreq(int[] freq){
        int max = 0;

        for(int i : freq){
            max = Math.max(i, max);
        }

        return max;
    }
}