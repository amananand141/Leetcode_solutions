class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;

        int ans = 0;

        for(int i=0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] weights, int days, int capacity){
        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }

        return requiredDays <= days;
    }
}
