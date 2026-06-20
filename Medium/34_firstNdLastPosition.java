class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        // binary search
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                start = mid;
                end = mid;
                break;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        if(start == -1) return new int[]{-1, -1};

        //expand left and right to get the first and last occurence
        while(start > 0 && nums[start-1] == target){
            start--;
        }
        while(end < nums.length-1 && nums[end+1] == target){
            end++;
        }
        
        return new int[]{start, end};
    }
}
