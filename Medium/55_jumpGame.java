class Solution {
    public boolean canJump(int[] nums) {
        int curr = 0;
        int n = nums.length; 

        for(int i=0; i<n; i++){
            if(curr < i){
                return false;
            }

            curr = Math.max(curr, i+nums[i]);

            if(curr >= n-1){
                return true;
            }
        }

        return false;
    }

    // public boolean canJump(int[] nums){
    //     int n = nums.length; 
    //     boolean []dp = new boolean[n];
    //     Arrays.fill(dp, false);
    //     dp[n-1] = true;
    //     for(int i=n-2; i>=0; i--){
    //         if(i+nums[i] >= n-1){
    //             dp[i] = true;
    //         }else{
    //             for(int j=i; j<=i+nums[i]; j++){
    //                 if(dp[j] == true){
    //                     dp[i] = true;
    //                     break;
    //                 }
    //                 dp[i] = false;
    //             }
                
    //         }
    //     }
    //     return dp[0];
    // }
}
