class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean res;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    res = helper(board, word, 0, visited, i, j);
                    if(res) return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int x, boolean[][] visited, int i, int j){
        if(x == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(x))
        return false;

        visited[i][j] = true;

        if(helper(board, word, x + 1, visited, i + 1, j) ||
            helper(board, word, x + 1, visited, i -1, j) ||
            helper(board, word, x + 1, visited, i, j + 1) ||
            helper(board, word, x + 1, visited, i, j - 1)){
                return true;
            }


        visited[i][j] = false;
        return false;


    }
}