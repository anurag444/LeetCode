class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int size = strs.length;

        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < size; i++){
            String word = strs[i];
            if(word == "N") continue;
            int[] map = new int[26];
            List<String> group = new ArrayList<>();
            for(int k = 0; k < word.length(); k++){
                map[word.charAt(k) - 'a']++;
            }

            group.add(word);

            //loop through other strings to find anagram
            for(int j = i + 1; j < size; j++){
                String newWord = strs[j];
                if(newWord == "N") continue;

                if(newWord.length() != word.length()) continue;

                int[] temp = Arrays.copyOf(map,26);

                for(int l = 0; l < newWord.length(); l++){
                    temp[newWord.charAt(l) - 'a']--;
                }

                boolean isAnag = true;
                for(int l = 0; l < temp.length; l++){
                    if(temp[l] != 0) isAnag = false;
                }

                if(isAnag){
                    group.add(newWord);
                    strs[j] = "N";
                } 
                
            }

            res.add(group);

        }


        return res;
    }
}