class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        // Add data
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});


        List<String> res = new ArrayList<>();
        
        backtrack(digits, 0, res, "", map);

        return res;
    }

    public void backtrack(String digits, int idx, List<String> res, String word, Map<Character, char[]> map){
        if(idx == digits.length()){
            if(word != "") res.add(word);
            return;
        }

        char c = digits.charAt(idx);
        char[] words = map.get(c);

        for(int i = 0; i < words.length; i++){
             word += words[i];
             backtrack(digits, idx + 1, res, word, map);
             word = word.substring(0, word.length() - 1);
        }
    }
}