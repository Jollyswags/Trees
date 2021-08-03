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
   public int countNodes(TreeNode root) {
        if(root == null) return 0;    
        return countNodesUtil(root);
    }
    
    public int countNodesUtil(TreeNode node){
        int lCount = 0, rCount = 0, sum = 1;
		
	
        if(node.left != null && node.left.left != null){
            lCount = countNodesUtil(node.left);
            rCount = countNodesUtil(node.right);
        }else{

            if(node.right != null) sum += 2;
		
            else if(node.left != null) sum += 1;
        }
		
        return lCount + rCount + sum; 
    }
}