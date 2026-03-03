class Solution {
    public int longestOnes(int[] arr, int k) {
        int l = 0;
        int r = 0;

        int n = arr.length; 
        int max = 0;
        int zeroCount = 0;

        for(r=0; r<n; r++){
            if(arr[r] == 0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(arr[l] == 0){
                    zeroCount--;
                }
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}
