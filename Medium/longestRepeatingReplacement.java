class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int len = s.length();
        int maxlen = 0;
        int maxfrq = 0;
        int[] frq = new int[26];

        while(r<len){
            char c = s.charAt(r);
            frq[c-'A']++;
            maxfrq = Math.max(maxfrq,frq[c-'A']);

            if((r-l+1)-maxfrq<=k){
                maxlen = Math.max(maxlen,(r-l+1));
            }else{
                frq[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }

        return  maxlen;
    }
}
