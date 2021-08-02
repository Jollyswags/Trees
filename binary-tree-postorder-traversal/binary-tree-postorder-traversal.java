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
  List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
          ans=new ArrayList<>();
       
        pT(root,ans);
        return ans;
    }
    public void pT(TreeNode root, List<Integer> ans)
    {
        if(root==null)
            return;
        pT(root.left,ans);
        pT(root.right,ans);
        ans.add(root.val);
}
}