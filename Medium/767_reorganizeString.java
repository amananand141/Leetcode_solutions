class Solution {
    class Pair{
        int f;
        char c;
        Pair(int f, char c){
            this.f = f;
            this.c = c;
        }
    }
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            freq[curr-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.f-a.f));

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair(freq[i], (char)('a' + i)));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(sb.length()!=0 && curr.c == sb.charAt(sb.length()-1)){
                if(pq.size() == 0)return "";
                Pair curr2 = pq.poll();
                pq.add(curr);
                curr = curr2;
            }

            sb.append(curr.c);
            if(curr.f > 1){
                pq.add(new Pair(curr.f-1, curr.c));
            }
        }

        return sb.toString();
    }
}
