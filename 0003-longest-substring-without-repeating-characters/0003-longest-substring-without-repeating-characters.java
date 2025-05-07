class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0; 
        int ans = 0;
        while(j < n){
            if(map.containsKey(s.charAt(j) - 'a') && map.get(s.charAt(j) - 'a') >= i){
                i = map.get(s.charAt(j) - 'a') + 1;
            }

            map.put(s.charAt(j)-'a', j);
           

            ans = Math.max(j - i + 1  , ans);
            j++;

        }

        return ans;
    }
}