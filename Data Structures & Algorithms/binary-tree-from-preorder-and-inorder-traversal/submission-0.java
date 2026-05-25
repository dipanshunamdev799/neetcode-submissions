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
    int preorderIndex = 0;
    HashMap<Integer,Integer> mp = new HashMap<>();  // inorder :: el:idx
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder - get the root->lhs->rhs
        //inorder - count of lhs and rhs
        for(int i=0; i<inorder.length; i++){
            int el = inorder[i];
            mp.put(el,i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int start,int end){
        if(start>end) return null;
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        int idx = mp.get(node.val);
        node.left = helper(preorder,start,idx-1);
        node.right = helper(preorder,idx+1,end);
        return node;
    }
}
