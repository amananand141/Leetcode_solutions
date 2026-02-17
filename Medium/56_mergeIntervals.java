class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        ArrayList<int[]> al = new ArrayList<>();
        int[] curr = new int[2];
        curr = intervals[0];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                al.add(curr);
                curr = intervals[i];
            }
        }
        al.add(curr);
        
        return al.toArray(new int[al.size()][]);
    }
}
