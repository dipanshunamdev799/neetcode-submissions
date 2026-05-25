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
            if(root.right==null){
                res.add(root.val);
                root = root.left;
            }else{
                TreeNode temp = root.right;
                while(temp.left!=null && temp.left!=root) temp = temp.left;
                if(temp.left==null){
                    temp.left = root;
                    res.add(root.val);
                    root = root.right;
                }else{
                    temp.left = null;
                    root = root.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}