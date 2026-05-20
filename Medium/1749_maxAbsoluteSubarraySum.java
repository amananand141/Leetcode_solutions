class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int result = Math.abs(nums[0]);
        int bestEnding = nums[0];
        int worstEnding = nums[0];

        for(int i=1; i<nums.length; i++){
            bestEnding = Math.max(bestEnding+nums[i], nums[i]);
            worstEnding = Math.min(worstEnding+nums[i], nums[i]);

            result = Math.max(result, Math.max(Math.abs(bestEnding), Math.abs(worstEnding)));
        }
        return result;
    }
}
