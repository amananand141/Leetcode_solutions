class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] nQueens = new char[n][n];

        // Fill the chess board with dots
        for(int i=0; i<n; i++){
            Arrays.fill(nQueens[i], '.');
        }

        solveNQ(n, output, nQueens, 0);
        return output;
    }

    public boolean isSafe(int n, char[][] nQueens, int row, int col){

        // Check for any queen in the same column above the current position
        for(int i=0; i<n; i++){
            if(nQueens[i][col] == 'Q'){
                return false;
            }
        }

        // Check upper right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(nQueens[i][j] == 'Q'){
                return false;
            }
        }

        // Check upper left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(nQueens[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void solveNQ(int n, List<List<String>> output, char[][] nQueens, int row){
        // Found a valid solution, Base case
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(char[] rowArray : nQueens){
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        // Try placing queen in each column of current row
        for(int col = 0; col < n; col++){
            // If current position is safe
            if(isSafe(n, nQueens, row, col)){
                nQueens[row][col] = 'Q';
                // Recursion for next row
                solveNQ(n, output, nQueens, row+1);
                // BackTracking for trying the next position
                nQueens[row][col] = '.';
            }
        }
    }
}
