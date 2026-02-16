// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         // if the intervals array is empty
//         int [][] newI = new int[intervals.length+1][2];
//         if(intervals.length == 0){
//             newI[0] = newInterval;
//             return newI;
//         }

//         // merge the two input arrays
//         int j = 0;
//         for(int i=0; i<intervals.length; i++){
//             newI[j] = intervals[i];
//             j++;
//         }
//         newI[j] = newInterval;

//         // sort the newly formed array with the first element of the row
//         Arrays.sort(newI, (a,b)->(a[0]-b[0]));

//         // now we'll merge the intervals
//         ArrayList<int[]> al = new ArrayList<>();
//         int []curr = newI[0];

//         for(int i=1; i<newI.length; i++){
//             if(newI[i][0] <= curr[1]){
//                 curr[1] = Math.max(curr[1], newI[i][1]);
//             }else{
//                 al.add(curr);
//                 curr = newI[i];
//             }
//         }
//         al.add(curr);
//         return al.toArray(new int[al.size()][]);
//     }
// }

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> al = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. Add all intervals before overlap
        while(i < n && intervals[i][1] < newInterval[0]){
            al.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        al.add(newInterval);

        // 3. Add remaining intervals
        while(i < n){
            al.add(intervals[i]);
            i++;
        }

        return al.toArray(new int[al.size()][]);
    }
}
