class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int row: rows){
            setZeroRow(row, matrix);
        }
        
        for(int col: cols){
            setZeroCol(col, matrix);
        }
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
}