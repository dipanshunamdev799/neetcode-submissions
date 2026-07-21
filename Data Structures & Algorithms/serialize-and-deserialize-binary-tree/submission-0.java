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

    int count = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        dfs(root,preorder,inorder);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append(Integer.toString(inorder.get(i)));
            sb.append(",");
        }
        for(int i=0; i<count; i++){
            sb.append(Integer.toString(preorder.get(i)));
            if(i!=count-1)
                sb.append(",");
        }
        return sb.toString();  // inorder + preorder
    }
    private void dfs(TreeNode node, List<Integer> preorder,List<Integer> inorder){
        if(node==null) return;
        count++;
        preorder.add(node.val);
        dfs(node.left,preorder,inorder);
        inorder.add(node.val);
        dfs(node.right,preorder,inorder);
    }

    HashMap<Integer,Integer> mp = new HashMap<>();
    int preorderIndex = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        String[] elements = data.split(",");
        count = elements.length/2;
        for(int i=0; i<count; i++){
            int el = Integer.parseInt(elements[i]);
            mp.put(el,i);
            inorder.add(el);
        }
        for(int i=count; i<count*2; i++){
            preorder.add(Integer.parseInt(elements[i]));
        }
        return helper(preorder,0,inorder.size()-1);
    }

    TreeNode helper(List<Integer> preorder,int start,int end){
        if(start>end) return null;

        TreeNode node = new TreeNode(preorder.get(preorderIndex++));

        int index = mp.get(node.val);
        node.left = helper(preorder,start,index-1);
        node.right = helper(preorder,index+1,end);

        return node;
    }

}
