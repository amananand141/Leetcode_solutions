class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0; //low = 0th index
        int h = arr.length-1; //high = at the last index

        while(l <= h){
            //we'll use binary search in this problem
            // First we calculate the mid index 
            int mid = l+(h-l)/2;

            //this will the number of missing values till the mid index(at the left side of the middle index)
            int missing = arr[mid] - (mid+1);

            if(missing < k){ // if the number of missing values if less than k then the required value will be present at the right side of the middle index
                l = mid+1;
            }else{  // else the required value will be present at the right of the middle index
                h = mid-1;
            }
        }
        // The ans will be given by adding the value of "k" in the current low index
        return l+k;
    }
}
