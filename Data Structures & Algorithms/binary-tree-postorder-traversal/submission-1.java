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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while(root!=null){
            res.add(root.val);
            if(root.right==null){
                root = root.left;
            }else{
                TreeNode temp = root.right;
                while(temp.left!=null) temp = temp.left;
                temp.left = root.left;
                temp = root;
                root = root.right;
                temp.right = null;
            }
        }
        Collections.reverse(res);
        return res;
    }
}