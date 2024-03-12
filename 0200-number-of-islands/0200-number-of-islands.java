class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        n = grid[0].length;
        m = grid.length;
        
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    UpdateGrid(i, j, grid);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void UpdateGrid(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >=m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        UpdateGrid(i + 1, j, grid);
        UpdateGrid(i, j - 1, grid);
        UpdateGrid(i - 1, j, grid);
        UpdateGrid(i, j + 1, grid);
        
    }
}