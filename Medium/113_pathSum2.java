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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    public void helper(TreeNode root, int targetSum, int sum, List<Integer> al){
        if(root == null){
            return;
        }
        sum += root.val;
        al.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(root.left != null){
            helper(root.left, targetSum, sum, al);
            al.remove(al.size()-1);
        }
        if(root.right != null){
            helper(root.right, targetSum, sum, al);
            al.remove(al.size()-1);
        }
    }
}
