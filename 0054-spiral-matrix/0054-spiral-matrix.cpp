class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        
        vector<int> v;

        int sc, sr = 0;
        int er = m-1;
        int ec = n-1;
        int total = m *n;

        while(sr <= er && sc <= ec){

          //traversing right to left
          for(int i = sc; i<=ec; i++){
            v.push_back(matrix[sr][i]);
          }
          sr++;
          for(int i = sr; i<= er; i++){
            v.push_back(matrix[i][ec]);
          }
          ec--;
          for(int i = ec; i >= sc &&  sr<=er; i--){
                v.push_back(matrix[er][i]);
          }
          er--;
          for(int i = er; i >= sr && sc<=ec; i--){
              v.push_back(matrix[i][sc]);
          }
          sc++;
        }

        return v;
    }
};