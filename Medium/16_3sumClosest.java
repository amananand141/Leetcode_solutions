class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int l = i+1;
            int r = n-1;

            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum-target);
                if(diff < min){
                    ans = sum;
                    min = diff;
                }
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}
