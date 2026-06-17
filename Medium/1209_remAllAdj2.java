class Solution {
    public class Pair{
        char c;
        int f;
        Pair(char c, int f){
            this.c = c;
            this.f = f;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            if (!st.isEmpty() && st.peek().c == curr) {
                st.peek().f++;

                if (st.peek().f == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(curr, 1));
            }
        }
        while(!st.isEmpty()){
            Pair now = st.pop();
            char curr = now.c;
            int freq = now.f;
            for(int i=0; i<freq; i++){
                sb.append(curr);
            }
        }

        return sb.reverse().toString();
    }
}
