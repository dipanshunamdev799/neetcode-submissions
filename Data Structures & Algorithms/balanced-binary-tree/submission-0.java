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
    public boolean isBalanced(TreeNode root) {
        fun(root);
        return ans;
    }
    int fun(TreeNode root){
        if(root==null) return 0;
        int lh = fun(root.left);
        int rh = fun(root.right);
        ans = ans && (Math.abs(lh-rh) <=1);
        return 1+Math.max(lh,rh);
    }
}
