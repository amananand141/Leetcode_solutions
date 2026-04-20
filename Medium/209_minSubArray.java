class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(high < n){
            sum += nums[high];
            while(sum >= target){
                min = Math.min(min, high-low+1);
                sum -= nums[low];
                low++;
            }
            high++;
        }

        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
