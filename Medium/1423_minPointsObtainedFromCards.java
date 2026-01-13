class Solution {
    public int maxScore(int[] arr, int k) {

        //The idea behind this approach is we'll calculate the window with the minimum sum and then subtract with the total sum
        int totalSum = 0;
        int n = arr.length;

        //Total sum calculation
        for(int i=0; i<n; i++){
            totalSum  += arr[i];
        }
        //If the size of the array is same as the no. of values to choose that means we have to select all the elements
        if(n == k){
            return totalSum;
        }
        
        int windowSum = 0;
        int windowSize = n-k;

        for(int i=0; i<windowSize; i++){
            windowSum += arr[i];
        }

        int minWindowSum = windowSum;
        // finding the window with the minimum sum 
        for(int i=windowSize; i<n; i++){
            windowSum = windowSum + arr[i] - arr[i-windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return totalSum - minWindowSum;
    }
}
