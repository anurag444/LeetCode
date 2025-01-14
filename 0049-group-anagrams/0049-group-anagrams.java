class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;

        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            String s1 = strs[i];
            if(s1 == "NA") continue;
            List<String> temp = new ArrayList<>();
            temp.add(s1);
            for(int j = i + 1; j < n; j++){
                
                String s2 = strs[j];

                if(s2 != "NA" && checkAnagram(s1, s2)){
                    temp.add(s2);
                    strs[j] = "NA";
                } 
            }

            res.add(temp);
        }

        if(strs[n - 1] != "NA"){
            res.add(new ArrayList<>(Arrays.asList(strs[n - 1])));
        }

        return res;


    }

    public boolean checkAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        int[] words = new int[26];

        for(char c : s1.toCharArray()){
            words[c - 'a']++;
        }

        for(char c : s2.toCharArray()){
            words[c - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(words[i] != 0) return false;
        }

        return true;
    }
}