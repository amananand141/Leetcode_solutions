class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length; // row
        int n = board[0].length; // col

        boolean[][] vis = new boolean[m][n]; // Track if the place is already visited to avoid looping
        boolean result = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){ // When the first word matches
                    result = helper(board, word, vis, 0, i, j);
                }
                if(result) return true;
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, boolean[][] vis, int idx, int i, int j){
        if(idx == word.length()){ // successfully matched the whole word in the matrix
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }

        vis[i][j] = true;

        if(helper(board, word, vis, idx+1, i-1, j) ||  // Recursive calls
        helper(board, word, vis, idx+1, i, j-1) || 
        helper(board, word, vis, idx+1, i+1, j) || 
        helper(board, word, vis, idx+1, i, j+1)){
            return true;
        }

        vis[i][j] = false; // Backtrack

        return false;
    }
}
