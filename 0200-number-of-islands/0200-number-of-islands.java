class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if we find a node with value 1, we increase the counter by 1 and set all connecting
                // neighbors to 0

                if(grid[i][j] == '1'){
                    count++;
                    setNeighborsZero(grid, i , j, m, n);
                }
            }
        }

        return count;
    }

    public void setNeighborsZero(char[][] grid, int x, int y, int m, int n){
        //check boundaries
        if(x < 0 || x >= m) return;
        if(y < 0 || y >= n) return;

        if(grid[x][y] == '0') return;


        grid[x][y] = '0';

        setNeighborsZero(grid, x+1, y, m, n);
        setNeighborsZero(grid, x, y+1, m, n);
        setNeighborsZero(grid, x-1, y, m, n);
        setNeighborsZero(grid, x, y-1, m, n);
    }
}