class Solution {
    class Pair{
        int dist;
        int index;
        Pair(int dist, int index){
            this.dist = dist;
            this.index = index;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.dist == b.dist){
                return a.index-b.index;
            }
            return a.dist-b.dist;
        });

        for(int i=0; i<arr.length; i++){
            int distance = Math.abs(arr[i]-x);
            pq.add(new Pair(distance, i));
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<k; i++){
            ans.add(arr[pq.poll().index]);
        }

        Collections.sort(ans);
        return ans;
    }
}
