class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k<=1){
            return 0;
        }
        int count = 0;
        int j = 0;
        int product = 1;
        for(int i=0; i<n; i++){
            product *= nums[i];
            while(product >= k && j<n){
                product /= nums[j];
                j++;
            }
            count += (i-j+1);
        }
        return count;
    }
}
