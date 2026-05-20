class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int bestCase = nums[0];
        int worstCase = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = nums[0];

        for(int i=1; i<nums.length; i++){
            total += nums[i];
            
            bestCase = Math.max(bestCase + nums[i], nums[i]);
            worstCase = Math.min(worstCase + nums[i], nums[i]);
            
            maxSum = Math.max(maxSum, bestCase);
            minSum = Math.min(minSum, worstCase);
        }
        if(total-minSum == 0){
            return maxSum;
        }
        return Math.max(maxSum, total-minSum);
    }
}
