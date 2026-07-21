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
        return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public boolean helper(TreeNode root,int mini, int maxi){
        if(root==null) return true;
        mini = Math.min(root.val,mini);
        maxi = Math.max(root.val,maxi);
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean res = true;
        res = res && (left==null ? true : left.val < root.val);
        res = res && (right==null ? true : right.val > root.val);
        res = res && (left==null ? true : left.val < mini);
        res = res && (right==null ? true : right.val > maxi);
        res = res && isValidBST(root.left);
        res = res && isValidBST(root.right);
        return res;
    }
}
