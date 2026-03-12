class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length; 

        return atmostK(nums, n, k) - atmostK(nums, n, k-1);
    }

    public int atmostK(int[] nums, int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int count=0;
        int l = 0;
        int r = 0;

        for(r=0; r<n; r++){
            int c = nums[r];

            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size() > k){
                int d = nums[l];
                map.put(d, map.get(d)-1);
                if(map.get(d) == 0){
                    map.remove(d);
                }
                l++;
            }

            count += (r-l+1);
        }

        return count;
    }
}
