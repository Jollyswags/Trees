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
      List<Integer> l;
    public int getMinimumDifference(TreeNode root) {
    l=new ArrayList<>();
        inorder(root,l);
        int i,diff=Integer.MAX_VALUE;
        for(i=0;i<l.size()-1;i++)
            if(l.get(i+1)-l.get(i)<diff)
                diff=l.get(i+1)-l.get(i);
        return diff;          
        
        
    }
    public void inorder(TreeNode root, List<Integer> l)
    {   if (root==null)
        return;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }
}