class Solution {
    public int numIslands(char[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        int n = grid[0].length;
        int m = grid.length;

        //check boundary cases
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != '1') return;

        //make the current cell 0
        grid[i][j] = '0';

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}