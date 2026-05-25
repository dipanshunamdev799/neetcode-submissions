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
         
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root,int mini, int maxi){
        if(root==null) return true;
        return (root.val > mini && root.val < maxi) && helper(root.left,mini,root.val) && helper(root.right,root.val,maxi);
    }
}
