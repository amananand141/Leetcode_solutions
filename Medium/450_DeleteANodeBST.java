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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            // when there is no left child
            if(root.left == null){
                return root.right;
            }

            // when there is no right child
            if(root.right == null){
                return root.left;
            }
            
            // when there are two children
            TreeNode successor = findSucc(root.right); // find the element to replace at that position
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    public TreeNode findSucc(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
