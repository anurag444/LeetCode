class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int IC = image[sr][sc];
        
        if(IC == color) return image;
        
        dfs(image, sr, sc, color, IC);
        
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int IC){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != IC) return;
        
        image[sr][sc] = color;
        
        dfs(image, sr + 1, sc, color, IC);
        dfs(image, sr - 1, sc, color, IC);
        dfs(image, sr, sc + 1, color, IC);
        dfs(image, sr, sc - 1, color, IC);
    }
}