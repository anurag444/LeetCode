class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for(int i = 0; i < n; i++){
            for(int j = 0;j < n; j++){
                if(board[i][j] != '.'){
                    //check rows
                    //checks cols
                    //check sub-box
                    
                    for(int k = 0; k < n; k++){
                        if(k == j) continue;

                        if(board[i][k] == board[i][j]) return false;
                    }

                    for(int k = 0; k < n; k++){
                        if(k == i) continue;

                        if(board[k][j] == board[i][j]) return false;
                    }

                    for(int x = i/3 * 3; x < i/3 * 3 + 3; x++){
                        for(int y = j/3 * 3; y < j/3 * 3 + 3; y++){
                            if(x == i && y == j) continue;

                            if(board[x][y] == board[i][j]) return false;
                        }
                    }

                }
            }
        }
        return true;
    }

}