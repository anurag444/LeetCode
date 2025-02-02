class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            createHash(map, str);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public void createHash(HashMap<String, List<String>> map, String str){
        int[] freq = new int[26];

        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append("#").append(count);
            }
            String hashValue = keyBuilder.toString();

        if(!map.containsKey(hashValue)){
            map.put(hashValue, new ArrayList<>());
        }
        List<String> list = map.get(hashValue);
        list.add(str);
        map.put(hashValue, list);
    }
}