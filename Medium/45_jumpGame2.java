class Solution {
    public int jump(int[] nums) {
        int jumps = 0; // Number of minimum jumps
        int end = 0; // End of the current jump range
        int farthest = 0; // Range we can reach from current level

        if(nums.length == 1){
            return 0;
        }

        for(int i=0; i<nums.length; i++){
            farthest = Math.max(farthest, i+nums[i]);

            // if we reach the end early
            if(farthest >= nums.length-1){
                ++jumps;
                break;
            }
            // if we've iterated through the current range now we'll make the next jump
            if(i == end){
                ++jumps;
                end = farthest;
            }
        }

        return jumps;
    }
}
