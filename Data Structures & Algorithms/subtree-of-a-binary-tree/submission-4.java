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
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(ans) return ans;
        if(subRoot==null) return true;
        if(root==null) return false;
        return ans|| isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null){
            if(p.val!=q.val){
                return false;
            }else{
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
        }else{
            return false;
        }
    }
}
