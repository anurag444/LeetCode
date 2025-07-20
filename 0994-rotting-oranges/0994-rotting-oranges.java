class Solution {
    public class Node{
        int row;
        int col;
        int time;
        
        Node(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int cntFresh = 0;
        int maxT = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //add rotten oranges to the queue
                if(grid[i][j] == 2){
                    q.offer(new Node(i, j, 0));
                }
                
                //keep count of fresh
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        
        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int time = q.peek().time;
            q.poll();
            maxT = Math.max(time, maxT);
            //add it's neghbours
            for(int i = 0; i < 4; i++){
                int row = r + delRow[i];
                int col = c + delCol[i];
                
                //rot the neighbor
                if(row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1){
                    cntFresh--;
                    grid[row][col] = 2;
                    q.offer(new Node(row, col, time + 1));
                }
            }
        }
        
        if(cntFresh == 0) return maxT;
        else return -1;
    
        
        
    }
}