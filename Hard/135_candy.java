class Solution {
    public int candy(int[] r) {
        int []dp = new int[r.length];
        int n = r.length;
        Arrays.fill(dp, 1);

        // Forward propagate
        for(int i=1; i<n; i++){
            if(r[i] > r[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }

        // Backward propagate
        for(int i=n-2; i>=0; i--){
            if(r[i] > r[i+1]){
                dp[i] = Math.max(dp[i], dp[i+1]+1);
            }
        }

        // sum of the dp array
        int sum = 0;
        for(int ele : dp){
            sum += ele;
        }

        return sum;
    }
}
