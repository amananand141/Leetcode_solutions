class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = distance.clone();
            for(int j=0; j<flights.length; j++){
                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];
                if(distance[s] != Integer.MAX_VALUE && distance[s] + wt < temp[d]){
                    temp[d] = distance[s]+wt;
                }
            }
            distance = temp;
        }

        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];
    }
}
