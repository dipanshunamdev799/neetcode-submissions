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
    int res = 0;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        helper(root);
        return res;
    }
    private int helper(TreeNode node){
        if(node==null) return Integer.MIN_VALUE;

        if(node.left==null && node.right==null) return node.val;

        if(node.left==null){
            int rightRes = helper(node.right);
            int ans = node.val + rightRes;
            res = Math.max(res,ans);
            res = Math.max(res,rightRes);
            res = Math.max(res,node.val);
            return Math.max(ans,node.val);
        }
        if(node.right==null){
            int leftRes = helper(node.left);
            int ans = node.val + leftRes;
            res = Math.max(res,ans);
            res = Math.max(res,leftRes);
            res = Math.max(res,node.val);
            return Math.max(node.val,ans);
        }

        int leftRes = helper(node.left);
        int rightRes = helper(node.right);

        res = Math.max(res,node.val);
        res = Math.max(res, leftRes + rightRes + node.val);
        res = Math.max(res, leftRes);
        res = Math.max(res, rightRes);
        res = Math.max(res, node.val + leftRes);
        res = Math.max(res, node.val + rightRes);

        return Math.max(node.val,node.val + Math.max(leftRes,rightRes));
    }
}
