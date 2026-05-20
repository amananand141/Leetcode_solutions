class Solution {
    public int maximumSum(int[] arr) {
        int oneDelete = Integer.MIN_VALUE;
        int noDelete = arr[0];
        int result = arr[0];

        for(int i=1; i<arr.length; i++){
            int prevNo = noDelete;
            int prevOne = oneDelete;
            noDelete = Math.max(noDelete+arr[i], arr[i]);
            int v2;
            if(prevOne == Integer.MIN_VALUE){
                v2 = arr[i];
            }else{
                v2 = prevOne+arr[i];
            }
            oneDelete = Math.max(v2, prevNo);
            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        return result;
    }
}
