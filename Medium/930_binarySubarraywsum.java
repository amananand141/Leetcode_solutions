class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,1);

        int prefix = 0;

        for(int num : nums){
            prefix += num;

            if(map.containsKey(prefix-goal)){
                count += map.get(prefix-goal);
            }

            map.put(prefix, map.getOrDefault(prefix, 0)+1);
        }

        return count;
    }
}
