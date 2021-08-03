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
     int count;
    public int sumEvenGrandparent(TreeNode root) {
        count=0;
        if(root==null)
            return 0;
        sum(root,null,null);
        return count;
    }
    public void sum(TreeNode root, TreeNode parent, TreeNode gparent)
    {
        if(root==null)
            return;
        if(gparent!=null && gparent.val %2==0)
            count+=root.val;
        sum(root.left,root,parent);
        sum(root.right,root,parent);
    }
}