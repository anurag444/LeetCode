class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        
        for(int right = 0; right < n; right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            }else{
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
        }
        
        return max;
    }
}