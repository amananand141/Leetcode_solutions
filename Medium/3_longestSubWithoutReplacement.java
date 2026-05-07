class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int low = 0;
        int high = 0;
        int ans = 0;

        for(high=0; high<s.length(); high++){
            while(set.contains(s.charAt(high))){
                set.remove(s.charAt(low));
                low++;
            }

            set.add(s.charAt(high));
            ans = Math.max(ans, high-low+1);
        }
        return ans;
    }
}
