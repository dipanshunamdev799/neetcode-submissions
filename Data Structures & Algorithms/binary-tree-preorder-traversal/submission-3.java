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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.add(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            res.add(top.val);
            if(top.right!=null) stack.add(top.right);
            if(top.left!=null) stack.add(top.left);
        }
        return res;
    }
}