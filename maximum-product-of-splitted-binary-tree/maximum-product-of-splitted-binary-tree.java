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
   
        long sumAll=0;
    long maxProduct;
    
    public int maxProduct(TreeNode root) {
        sumAll=modify(root);
        maxProduct=1;
        findMaxP(root);
        return (int)(maxProduct % (int)(Math.pow(10, 9) + 7));
    }
    
    public void findMaxP(TreeNode root){
        if(root==null) return;
        
        if(root.left!=null){
            long ans=(root.left.val*(sumAll-root.left.val));
            maxProduct=Math.max(maxProduct,ans);
            findMaxP(root.left);
        }
        
        if(root.right!=null){
            long ans=(root.right.val*(sumAll-root.right.val));
            maxProduct=Math.max(maxProduct,ans);
            findMaxP(root.right);
        }
    }
    
    public int modify(TreeNode root){
        if(root==null) return 0;
        
        int left=modify(root.left);
        int right=modify(root.right);
        return root.val=root.val+left+right;
        
    }
        
    }
