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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        fun(root);
        return ans;
    }
    public int fun(TreeNode root){
        if(root==null) return 0;
        int lh = fun(root.left);
        int rh = fun(root.right);
        ans = Math.max(lh+rh,ans);
        return 1 + Math.max(lh,rh);
    }
}
