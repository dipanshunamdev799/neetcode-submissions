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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderTraversal(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    private void preorderTraversal(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("null").append(",");
            return;
        }
        sb.append(Integer.toString(node.val)).append(",");
        preorderTraversal(node.left,sb);
        preorderTraversal(node.right,sb);
    }

    int idx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] preorder = data.split(",");
        TreeNode root = buildTree(preorder);
        return root;
    }
    private TreeNode buildTree(String[] preorder){
        String el = preorder[idx++];
        if(el.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(el));
        node.left = buildTree(preorder);
        node.right = buildTree(preorder);
        return node;
    }
}
