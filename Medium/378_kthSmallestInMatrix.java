class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int res = 0;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(isPossible(matrix, k, mid)){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    public boolean isPossible(int[][] arr, int k, int target){
        if(noOfElements(arr, target) >= k){
            return true;
        }
        return false;
    }

    public int noOfElements(int[][] arr, int target){
        int count = 0;
        int r = arr.length-1;
        int c = 0;
        while(r>=0 && c<arr.length){
            if(arr[r][c] > target){
                r--;
            }else{
                count += (r+1);
                c++;
            }
        }
        return count;
    }
}
