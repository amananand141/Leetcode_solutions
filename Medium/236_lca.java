/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

    // public int helper(TreeNode root, TreeNode p, TreeNode q){
    //     if(root == null){
    //         return 0;
    //     }
    //     int left = helper(root.left, p, q);
    //     int right = helper(root.right, p, q);
    //     int self = 0;
    //     if(root == p || root == q){
    //         self = 1;
    //     }
    //     self = left + self + right;
    //     if(self == 2 && ans == null){
    //         ans = root;
    //     }
    //     return self;
    // }
}
