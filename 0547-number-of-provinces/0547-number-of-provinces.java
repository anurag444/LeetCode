class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; 
        
        
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        
        return count;
    }
    
    public void dfs(int idx, int[][] isConnected, boolean[] visited){
        int n = isConnected[0].length;
        visited[idx] = true;
        
        for(int i = 0; i < n; i++){
            if(i != idx && isConnected[idx][i] == 1 && visited[i] == false){
                dfs(i, isConnected, visited);
            }
        }
    }
}