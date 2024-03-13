class Solution {
    private int count = 0;
    private int n;
    private int m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid[0].length;
        m = grid.length;
        
        int max = 0;
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    DFS(i, j, grid);
                    
                    max = Math.max(count, max);
                    count = 0;
                }
            }
        }
        
        
        return max;
    }
    
    public void DFS(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 0;
        count++;
        DFS(i + 1, j, grid);
        DFS(i - 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
    }
}