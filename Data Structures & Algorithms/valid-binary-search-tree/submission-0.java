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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return (left==null ? true : left.val < root.val) && ( right==null ? true : right.val > root.val ) && isValidBST(root.left) && isValidBST(root.right);
    }
}
