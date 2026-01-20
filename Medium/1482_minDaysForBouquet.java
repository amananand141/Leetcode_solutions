class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;;

        if((long)m*k > bloomDay.length){
            return -1;
        }

        for(int i=0; i<bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while(low < high){
            int mid = low +(high - low)/2;

            if(isPossible(bloomDay, mid, m, k)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] arr, int mid, int count, int k){

        int bouquet = 0;
        int streak = 0;
        for(int i=0; i<arr.length; i++){
            if(mid >= arr[i]){
                streak++;
                if(streak == k){
                    bouquet += 1;
                    streak = 0;
                }
            }else{
                streak = 0;
            }
        }
        if(bouquet >= count){
            return true;
        }
        return false;
    }
}
