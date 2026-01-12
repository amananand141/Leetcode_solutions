class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int count = 1;
        int init = nums[0];
        int max = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == init){
                continue;
            }
            if(nums[i] == init + 1){
                count++;
                max = Math.max(max, count);
                init = nums[i];
            }else{
                count = 1;
                init = nums[i];
            }
        }
        return max;
    }
}
