class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i, max;
        i = 0;
        max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i){
                i = map.get(s.charAt(j)) + 1;
            }

            map.put(s.charAt(j), j);

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}