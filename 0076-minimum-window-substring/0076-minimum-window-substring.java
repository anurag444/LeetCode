class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (tLen > sLen) return "";

        int[] targetFreq = new int[58]; // For ASCII 'A' (65) to 'z' (122)

        for (int i = 0; i < tLen; i++) {
            targetFreq[t.charAt(i) - 'A']++;
        }

        int[] windowFreq = new int[58];

        int minWindowLength = Integer.MAX_VALUE;
        int windowStart = 0; // Start index of the result substring
        int left = 0;
        int charsMatched = 0;

        for (int right = 0; right < sLen; right++) {
            char rightChar = s.charAt(right);
            int rIdx = rightChar - 'A';
            windowFreq[rIdx]++;

            // Count match only if this character is required and within limit
            if (targetFreq[rIdx] > 0 && windowFreq[rIdx] <= targetFreq[rIdx]) {
                charsMatched++;
            }

            // When all characters from t are matched
            while (charsMatched == tLen) {
                // Update result if smaller window found
                if ((right - left + 1) < minWindowLength) {
                    minWindowLength = right - left + 1;
                    windowStart = left;
                }

                char leftChar = s.charAt(left);
                int lIdx = leftChar - 'A';
                windowFreq[lIdx]--;

                // If a required character is removed from window
                if (targetFreq[lIdx] > 0 && windowFreq[lIdx] < targetFreq[lIdx]) {
                    charsMatched--;
                }

                left++;
            }
        }

        return minWindowLength == Integer.MAX_VALUE
            ? ""
            : s.substring(windowStart, windowStart + minWindowLength);
    }
}
