class Solution {
    
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        
        boolean isRowZero = false;
        boolean isColZero = false;
        
        for(int i = 1; i< n; i++){
            if(matrix[0][i] == 0){
                isRowZero = true;
            }
        }
        
        for(int i = 1; i< m; i++){
            if(matrix[i][0] == 0){
                isColZero = true;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        
        
        for(int i = 1; i< n; i++){
            if(matrix[0][i] == 0){
                setZeroCol(i, matrix);
            }
        }
        for(int i = 1; i< m; i++){
            if(matrix[i][0] == 0){
                setZeroRow(i, matrix);
            }
        }
        
        
        
        if(matrix[0][0] == 0){
            setZeroRow(0, matrix);
            setZeroCol(0, matrix);
        }
        
        if(isColZero) setZeroCol(0, matrix);
        if(isRowZero) setZeroRow(0, matrix);
            
    }
    
    public void setZeroRow(int row, int[][] matrix){
        int n = matrix[0].length;
        for(int col = 0; col < n; col++){
            matrix[row][col] = 0;
        }
    }
    
    public void setZeroCol(int col, int[][] matrix){
        int m = matrix.length;
        for(int row = 0; row < m; row++){
            matrix[row][col] = 0;
        }
    }
    
    
    // O(n + m) space solution
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         Set<Integer> rows = new HashSet<>();
//         Set<Integer> cols = new HashSet<>();
        
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(matrix[i][j] == 0){
//                     rows.add(i);
//                     cols.add(j);
//                 }
//             }
//         }
        
//         for(int row: rows){
//             setZeroRow(row, matrix);
//         }
        
//         for(int col: cols){
//             setZeroCol(col, matrix);
//         }
//     }
    

}