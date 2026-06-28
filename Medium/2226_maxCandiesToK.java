class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 1;
        int n = candies.length;

        for(int i=0; i<n; i++){
            high = Math.max(high, candies[i]);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(candies, mid, k)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] candies, long candy, long kid){
        long count = 0;
        for(int i=0; i<candies.length; i++){
            count += candies[i]/candy;
        }
        return count >= kid;
    }
}
