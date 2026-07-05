class Solution {
    class Pair{
        int profit;
        int weight;
        Pair(int profit, int weight){
            this.profit = profit;
            this.weight = weight;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair(profits[i], capital[i]);
        }
        Arrays.sort(arr, (a,b)->(a.weight-b.weight));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int idx = 0;
        while(k-- > 0){
            while(idx < n){
                if(arr[idx].weight > w){
                    break;
                }
                pq.add(arr[idx].profit);
                idx++;
            }
            if(pq.isEmpty())return w;
            w = w+pq.poll();
        }

        return w;
    }
}
