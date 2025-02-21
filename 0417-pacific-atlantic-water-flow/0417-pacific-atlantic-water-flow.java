class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(checkPacific(heights, i, j, m, n) && checkAtlantic(heights, i, j, m, n)){
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }

        return res;
    }

    public boolean checkPacific(int[][] heights, int i, int j, int m, int n){
        if(i == 0 || j == 0) return true;

        boolean up = false, left = false;
        if(i - 1 >= 0 && heights[i][j] >= heights[i - 1][j]){
            up = checkPacific(heights, i - 1, j, m, n);
        }

        if(j - 1 >= 0 && heights[i][j] >= heights[i][j - 1]){
            left = checkPacific(heights, i, j - 1, m, n);
        }

        return up || left;
    }

    public boolean checkAtlantic(int[][] heights, int i, int j, int m, int n){
        if(i == m -1 || j ==  n-1) return true;

        boolean down= false, right= false;
        if(i + 1 < m && heights[i][j] >= heights[i + 1][j]){
            down = checkAtlantic(heights, i + 1, j, m, n);
        }

        if(j + 1 < n && heights[i][j] >= heights[i][j + 1]){
            right = checkAtlantic(heights, i, j + 1, m, n);
        }

        return down || right;  
    }
}