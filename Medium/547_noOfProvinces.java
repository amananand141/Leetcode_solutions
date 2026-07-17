class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;

        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i] == false){
                dfs(isConnected, vis, n, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] arr, boolean[] vis, int n, int i){
        if(i<0 || i>n-1 || vis[i] == true){
            return;
        }
        vis[i] = true;
        for(int j=0; j<n; j++){
            if(i!=j && vis[j] == false && arr[i][j] == 1){
                dfs(arr, vis, n, j);
            }
        }
    }
}
