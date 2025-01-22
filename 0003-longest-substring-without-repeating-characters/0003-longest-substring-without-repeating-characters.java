class Solution {
    public int lengthOfLongestSubstring(String s) {
        //use hash map to store index and then keep two pointers
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int max = 0;
        int n = s.length();


        for(int j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j)) && (i <= map.get(s.charAt(j)))){
                i = map.get(s.charAt(j)) + 1;
            }
            
            map.put(s.charAt(j), j);
            

            if((j - i + 1) > max)
                max = j - i + 1;
        }



        return max;

    }
}