class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        
        Queue<Node> q = new LinkedList<>();
        
        //add all nodes to the queue which has value 0;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
        
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int d = q.peek().d;
            
            q.poll();
            dist[x][y] = d;
            for(int i = 0; i < 4; i++){
                int nrow = x + delrow[i]; 
	            int ncol = y + delcol[i]; 
                
                
                if(nrow < 0 || ncol < 0 || nrow >= m ||ncol >= n || visited[nrow][ncol]) continue;
                
                visited[nrow][ncol] = true;
                q.add(new Node(nrow, ncol, d + 1));
                
            }
            
        }
        
        return dist;
        
        
    }
    
    public class Node{
        int x;
        int y;
        int d;
        
        Node(int x, int y, int d){
            this.x= x;
            this.y = y;
            this.d = d;
        }
    }
}