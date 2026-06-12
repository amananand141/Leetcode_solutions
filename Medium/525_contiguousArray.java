class Solution {
    public int findMaxLength(int[] nums) {
        int one = 0;
        int zero = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }

            int diff = zero-one;

            if(diff == 0){
                ans = Math.max(ans, i+1);
            }

            if(map.containsKey(diff)){
                ans = Math.max(ans, i-map.get(diff));
            }
            else{
                map.put(diff, i);
            }
        }

        return ans;
    }
}
