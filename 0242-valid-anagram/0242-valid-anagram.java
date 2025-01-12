class Solution {
    public boolean isAnagram(String s, String t) {
        int[] words = new int[26];

    for(char c : s.toCharArray()){
        words[c - 'a']++;
    }

    for(char c : t.toCharArray()){
        words[c - 'a']--;
    }

    for(int i = 0; i < 26; i++){
        if(words[i] > 0) return false;
    }

    return true;
    }
}