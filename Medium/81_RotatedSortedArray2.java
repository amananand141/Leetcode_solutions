class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            // finding the middle index
            int mid = low + (high-low)/2;

            // If the middle index contains the target value
            if(nums[mid] == target){
                return true;
            }

            // if mid, low and high all have duplicate values
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
            }else if(nums[low] <= nums[mid]){ // left half of the array is sorted
                
                // left half contains the answer
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }
                // right half has the answer
                else{
                    low = mid+1;
                }
            }else{ // right half of the array is sorted
                
                // right half contains the answer
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                // left half has the answer
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
