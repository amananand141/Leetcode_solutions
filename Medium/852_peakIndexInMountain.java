class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid > 0 && mid < arr.length-1){
                if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]){
                    return mid;
                }else if(arr[mid-1] < arr[mid]){
                    low = mid+1;
                }else if(arr[mid+1] < arr[mid]){
                    high = mid-1;
                }
            }
            if(low == 0)low++;
            if(high == arr.length-1)high--;    
        }

        return -1;
    }
}
