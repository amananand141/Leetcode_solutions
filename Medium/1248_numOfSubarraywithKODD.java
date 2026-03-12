class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length; 
        
        return atmostK(nums, n, k) - atmostK(nums, n, k-1);
    }

    public int atmostK(int[] nums, int n, int k){
        int count = 0;

        int odd = 0;
        int left = 0;
        int right = 0;

        for(right=0; right<n; right++){
            if(nums[right]%2 == 1){
                odd++;
            }
            while(odd > k){
                if(nums[left]%2==1){
                    odd--;
                }
                left++;
            }

            count += (right-left+1);
        }

        return count;
    }
}
