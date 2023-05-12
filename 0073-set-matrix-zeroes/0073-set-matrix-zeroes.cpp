class Solution {
public:
    void nullifyRows(vector<vector<int>>& matrix, int row){
        for(int i = 0; i < matrix[0].size(); i++){
                matrix[row][i] = 0;
        }
    }

    void nullifyCols(vector<vector<int>>& matrix, int col){
        for(int i = 0; i < matrix.size(); i++){
                matrix[i][col] = 0;
        }
    }

    void setZeroes(vector<vector<int>>& matrix) {
        bool isRowZero = false;
        bool isColZero = false;

        int m = matrix.size();
        int n = matrix[0].size();

        if(m ==1 && n ==1) return;

        //check if first row and column are zero
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                isColZero = true;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                isRowZero = true;
                break;
            }
        }

        //Now for the rest of the matrix
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                nullifyRows(matrix, i);
            }
        }

        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0){
                nullifyCols(matrix, i);
            }
        }

        //Nullify first row and column
        if(isRowZero){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
        if(isColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }


    }
};