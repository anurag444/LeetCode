class Solution {
    public int numEnclaves(int[][] grid) {
       int n = grid[0].length;
        int m = grid.length;
        
        boolean[][] set = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //check for boundary nodes and if it is O
                if((i == 0 || j == 0 || i == m -1 || j == n - 1) && grid[i][j] == 1){
                    dfs(i, j, set, m, n, grid);
                }
            }
        }
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //check if value if O and not marked
                if(!set[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i, int j, boolean[][] set, int m, int n, int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || set[i][j]) return;
        
        //mark as visited
        set[i][j] = true;
        
        dfs(i + 1, j, set, m, n, grid);
        dfs(i - 1, j, set, m, n, grid);
        dfs(i, j + 1, set, m, n, grid);
        dfs(i, j - 1, set, m, n, grid);
    }
}