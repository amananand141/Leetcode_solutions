class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        // row finding
        int lr = 0;
        int hr = r-1;

        int col = -1;

        while(lr <= hr){
            int m = lr + (hr-lr)/2;
            if(matrix[m][0] == target){
                return true;
            }else if(matrix[m][0] > target){
                hr = m-1;
            }else if(matrix[m][0] < target && matrix[m][c-1] >= target){
                col = m;
                break;
            }else{
                lr = m+1;
            }
        }
        if(col == -1)return false;

        // col finding
        int lc = 0;
        int hc = c-1;

        while(lc <= hc){
            int m = lc + (hc-lc)/2;
            if(matrix[col][m] == target){
                return true;
            }else if(matrix[col][m] > target){
                hc = m-1;
            }else{
                lc = m+1;
            }
        }

        return false;
    }
}
