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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int x = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<x; i++){
                TreeNode current = queue.element();
                temp.add(current.val);
                queue.remove();
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null)  queue.add(current.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
