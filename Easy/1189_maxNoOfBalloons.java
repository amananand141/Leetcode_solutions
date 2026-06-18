class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        
        for(int i=0; i<text.length(); i++){
            char curr = text.charAt(i);
            freq[curr - 'a']++;
        }

        int min = freq[1];
        min = Math.min(min, freq['a' - 'a']);
        min = Math.min(min, freq['l' - 'a']/2);
        min = Math.min(min, freq['o' - 'a']/2);
        min = Math.min(min, freq['n' - 'a']);

        return min;
    }
}
