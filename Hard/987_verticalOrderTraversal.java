class Solution {
    class Pair {
        TreeNode node;
        int col, row;

        Pair(TreeNode n, int c, int r) {
            this.node = n;
            this.col = c;
            this.row = r;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            int row = curr.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            if(node.left != null)
                q.add(new Pair(node.left, col - 1, row + 1));
            
            if(node.right != null)
                q.add(new Pair(node.right, col + 1, row + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
