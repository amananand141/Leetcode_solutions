class Solution {
    class Point{
        int index;
        double dist;
        Point(int index, double dist){
            this.index = index;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->(Double.compare(a.dist, b.dist)));
        for(int i=0; i<points.length; i++){
            double distance = distance(points[i][0], points[i][1]);
            pq.add(new Point(i, distance));
        }

        int[][] ans = new int[k][2];
        int j = 0;
        for(int i=0; i<k; i++){
            Point curr = pq.poll();
            ans[j++] = points[curr.index];
        }

        return ans;
    }

    public double distance(int x, int y){
        return Math.sqrt((x * x) + (y * y));
    }
}
