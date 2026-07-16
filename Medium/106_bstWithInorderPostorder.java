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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, map, postorder.length-1, 0, postorder.length-1);
    }

    public TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int index, int low, int high){
        if(low > high)return null;
        TreeNode root = new TreeNode(postorder[index]);
        int mid = map.get(postorder[index]);

        root.right = helper(postorder, map, index-1, mid+1, high);
        root.left = helper(postorder, map, index-(high-mid)-1, low, mid-1);

        return root;
    }
}
