class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        while(low <= high){
            int mid = low + (high-low)/2;
            int x = largestSum(nums, k, mid);
            if(x != -1){
                ans = Math.min(ans, x);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int largestSum(int[] nums, int k, int limit){
        int largestS = 0;
        int maxSum = 0;
        int parts = 1;
        for(int num : nums){
            if(largestS + num > limit){
                parts++;   
                largestS = num;
            }else{
                largestS += num;
            }
            maxSum = Math.max(maxSum, largestS);
        }

        if(parts <= k){
            return maxSum;
        }
        return -1;
    }
}
