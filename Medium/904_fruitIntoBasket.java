class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;

        if(n == 1)return 1;

        int low = 0;
        int high = 0;
        int max = -1;

        for(high=0; high<n; high++){
            int curr = fruits[high];
            map.put(curr, map.getOrDefault(curr, 0)+1);

            if(map.size() <= 2){
                max = Math.max(max, high-low+1);
            }

            while(map.size() > 2){
                int rem = fruits[low];
                map.put(rem, map.get(rem)-1);
                if(map.get(rem) == 0){
                    map.remove(rem);
                }
                low++;
            }
        }
        return max;
    }
}
