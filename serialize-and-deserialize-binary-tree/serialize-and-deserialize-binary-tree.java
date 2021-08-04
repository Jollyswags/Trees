/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serailizeHelper(root,str);
        return str.toString();
    }
    void serailizeHelper(TreeNode root,StringBuilder str)
    {
        if(root == null)
        {
            str.append("null,");
            return ;
        }
        str.append(root.val+",");
        serailizeHelper(root.left,str);
        serailizeHelper(root.right,str);
    }
    // Decodes your encoded data to tree.
    int index ;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return deserializeHelper(arr);
    }
    TreeNode deserializeHelper(String[] arr)
    {
        if(index >= arr.length || arr[index].equals("null"))
        {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));