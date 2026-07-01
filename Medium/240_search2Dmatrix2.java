class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length;

        int r = m-1;
        int c = 0;

        while(r>=0 && c<n){
            int num = matrix[r][c];
            if(num == target){
                return true;
            }else if(num > target){
                r--;
            }else{
                c++;
            }
        }
        return false;
    }
}
