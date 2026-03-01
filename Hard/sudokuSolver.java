class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        helper(board, n);
    }

    public boolean helper(char[][] board, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(board[i][j] == '.'){ // If the place is empty
                    
                    for(int k=1; k<=9; k++){ // Check for all the 9 integers
                        if(isSafe(board, k, i, j)){
                            board[i][j] = (char)(k+'0'); // Assigning the value
                            if(helper(board, n)){ // Recursion
                                return true;
                            }
                            board[i][j] = '.'; // Backtracking
                        }
                    }
                    
                    return false;
                }

            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int key, int row, int col){
        int n = board.length;
        char ch = (char)(key+'0');
        // Check for the values in row
        for(int i=0; i<n; i++){
            if(board[row][i] == ch){
                return false;
            }
        }

        // Check for the values in column
        for(int i=0; i<n; i++){
            if(board[i][col] == ch){
                return false;
            }
        }

        // Check in the 3x3 matrix
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[startRow+i][startCol+j] == ch){
                    return false;
                }
            }
        }

        return true;
    }
}
