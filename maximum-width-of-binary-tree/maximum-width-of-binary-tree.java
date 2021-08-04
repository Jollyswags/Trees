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
     HashMap<Integer,Integer> hm=new HashMap<>();
        int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        width(root,0,0);
        return maxWidth;
    }
    public void width(TreeNode root,int depth,int position){
        if(root==null){
            return;
        }
        if(!hm.containsKey(depth)){
            hm.put(depth,position);
        }
        maxWidth=Math.max(maxWidth,position-hm.get(depth)+1);
        width(root.left,depth+1,position*2);
        width(root.right,depth+1,position*2+1);
}
}