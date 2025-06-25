class Solution {
    public String minWindow(String s, String t) {
        // store all the freq of t
        // iterate till matched 
        // keep reducing from left till matched 

        int m = s.length();
        int n = t.length();

        int[] tFreq = new int[58];

        for(char c : t.toCharArray()){
            tFreq[c - 'A']++;
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int[] windowFreq = new int[58];
        int charCount = 0;
        int windowStart = 0;
        

        for(int right = 0; right < m; right++){

            char c = s.charAt(right);
            int rightIndex = c - 'A';
            windowFreq[rightIndex]++;

            //we check if the char is in t and also make sure the freq is in range
            if(tFreq[rightIndex] > 0 && windowFreq[rightIndex] <= tFreq[rightIndex]){
                charCount++;
            }

            while(charCount == n){
                // we found the window that has all char in t, so update the min len and keep moving
                // left till the condition is satisfied.

                if(min > (right - left + 1)){
                    min = (right - left + 1);
                    windowStart = left;
                }

                char leftChar = s.charAt(left);
                int leftIndex = leftChar - 'A';

                windowFreq[leftIndex]--;

                //check if by moving left, did we remove the char in t
                if(tFreq[leftIndex] > 0 && windowFreq[leftIndex] < tFreq[leftIndex]){
                    charCount--;
                }


                left++;

            }


        }

        return min == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + min);
    }
}