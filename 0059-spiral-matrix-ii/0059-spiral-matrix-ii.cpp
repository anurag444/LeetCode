class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        int sc, sr = 0;
        int er = n-1;
        int ec = n-1;

        int val = 1;

        while(sr <= er && sc <= ec){

          //traversing right to left
          for(int i = sc; i<=ec; i++){
            matrix[sr][i] = val;
            val++;
          }
          sr++;
          for(int i = sr; i<= er; i++){
            matrix[i][ec] = val;
            val++;
          }
          ec--;
          for(int i = ec; i >= sc &&  sr<=er; i--){
                matrix[er][i] = val;
                val++;
          }
          er--;
          for(int i = er; i >= sr && sc<=ec; i--){
              matrix[i][sc] = val;
              val++;
          }
          sc++;
        }

        return matrix;
    }
};