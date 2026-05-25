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
        if(root==null) return root;
        if(root.val < key){
            // search right
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
            // search left
            root.left = deleteNode(root.left,key);
        }else{
            // delete current node
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            // left and right both not null
            // minimum value from RST
            int mini = helper(root.right);
            root.val = mini;
            root.right = deleteNode(root.right,mini);
        }
        return root;
    }
    private int helper(TreeNode root){
        if(root==null) return -1;
        while(root.left!=null) root = root.left;
        return root.val;
    }

}