/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans = true;
    public boolean isCompleteTree(TreeNode root) {
        bfs(root);
        return ans;
    }
    public void bfs(TreeNode root){
        if(root == null)return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.peek() != null){
            TreeNode curr = q.poll();
            q.offer(curr.left);
            q.offer(curr.right);
        }
        while(!q.isEmpty() && q.peek() == null){
            TreeNode curr = q.poll();
        }
        if(!q.isEmpty()){
            ans = false;
        }
    }
}
