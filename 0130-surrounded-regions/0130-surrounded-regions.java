class Solution {
    public void solve(char[][] board) {
        int n = board[0].length;
        int m = board.length;
        
        boolean[][] set = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //check for boundary nodes and if it is O
                if((i == 0 || j == 0 || i == m -1 || j == n - 1) && board[i][j] == 'O'){
                    dfs(i, j, set, m, n, board);
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //check if value if O and not marked
                if(!set[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    public void dfs(int i, int j, boolean[][] set, int m, int n, char[][] board){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || set[i][j]) return;
        
        //mark as visited
        set[i][j] = true;
        
        dfs(i + 1, j, set, m, n, board);
        dfs(i - 1, j, set, m, n, board);
        dfs(i, j + 1, set, m, n, board);
        dfs(i, j - 1, set, m, n, board);
    }
}