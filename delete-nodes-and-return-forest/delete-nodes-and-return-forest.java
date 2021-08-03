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
     List<TreeNode> v = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    TreeNode dfs(TreeNode root){
        if(root == null) return root;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(set.contains(root.val)){
            if(root.left != null) v.add(root.left);
            if(root.right != null) v.add(root.right);
            return null;  
        }
        return root;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int num : to_delete) set.add(num);
        dfs(root);
        if(!set.contains(root.val)) v.add(root);
        return v;
    }
    
}