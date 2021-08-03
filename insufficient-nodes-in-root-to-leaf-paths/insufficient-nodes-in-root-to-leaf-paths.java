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
      public TreeNode sufficientSubset(TreeNode root, int limit) {
        return remove(root, 0, limit) ? null : root;
    }
    
    boolean remove(TreeNode node, int count, int limit){
        if(node == null) return false;
        if(node.left==null && node.right==null) return count + node.val < limit;
        
        boolean removeLeft = remove(node.left, count + node.val, limit);
        boolean removeRight = remove(node.right, count + node.val, limit);
        
        if(removeLeft) node.left = null;
        if(removeRight) node.right = null;
        
        return node.left == null && node.right == null;
    }
}
