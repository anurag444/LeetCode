class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            checkPattern(map, str);
        }

        //now we have the hashmap

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
        
    }

    public void checkPattern(Map<String, List<String>> map, String str){
        //first we generate the pattern string

        String pattern = "";

        int[] freq = new int[26];
        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            pattern = pattern +  freq[i] + "#";
        }

        //we create a new array list if key is not present
        map.putIfAbsent(pattern, new ArrayList<>());

        List<String> temp = new ArrayList<>();
        temp = map.get(pattern);
        temp.add(str);

        map.put(pattern, temp);
    }


}