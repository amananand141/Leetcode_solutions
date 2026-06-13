class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length; 
        int n = secondList.length; 

        if(n == 0 || m == 0){
            return new int[0][0];
        }

        ArrayList<int[]> al = new ArrayList<>();
        
        int[] f = new int[2];
        int i = 0;
        int[] s = new int[2];
        int j = 0;
        

        while(i<m && j<n){
            f = firstList[i];
            s = secondList[j];
            if((f[1] >= s[0] && f[1] <=s[1]) || (s[1] >= f[0] && s[1] <= f[1])){
                int[] curr = new int[2];
                curr[0] = Math.max(f[0], s[0]);
                curr[1] = Math.min(f[1], s[1]);
                al.add(curr);
            }
            if(f[1] < s[1]){
                i++;
            }else{
                j++;
            }
        }

        return al.toArray(new int[al.size()][]);
    }
}
