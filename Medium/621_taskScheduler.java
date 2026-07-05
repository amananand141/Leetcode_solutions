class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count the frequency of all the characters
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char task : tasks){
            freq[task - 'A']++; 
        }

        for(int f : freq){
            maxFreq = Math.max(maxFreq, f);
        }

        int maxCount = 0;
        for(int f : freq){
            if(f == maxFreq){
                maxCount++;
            }
        }

        return Math.max(tasks.length, ((maxFreq-1)*(n+1) + maxCount));// important formula;
    }
}
