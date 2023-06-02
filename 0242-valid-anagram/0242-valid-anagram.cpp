class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char, int> map;

        int n = s.size();
        int m = t.size();

        if(n != m) return false;

        unordered_map<char,int> smap;
        unordered_map<char,int> tmap;
        
        for(int i = 0; i < m; i++){
            smap[s[i]]++;
            tmap[t[i]]++;
        }
        
        for(int i = 0; i < smap.size(); i++){
            if(smap[i] != tmap[i]) return false;
        }
        return true;
        
    }
};