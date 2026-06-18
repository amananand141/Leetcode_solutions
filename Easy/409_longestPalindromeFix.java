class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int n = s.length();

        for(char c : s.toCharArray()){
            freq[c]++;
        }

        boolean oddFound = false;
        int count = 0;
        for(int i=0; i<128; i++){
            int f = freq[i];
            count += (f/2)*2;
            if(f%2 == 1){
                oddFound = true;
            }
        }
        if(oddFound){
            count += 1;
        }

        return count;
    }
}
