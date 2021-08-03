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
       public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        ArrayList<Integer> path=new ArrayList<>();
        int[]count=new int[1];
        helper(root,targetSum,count,path);
        return count[0];
    }
    public void helper(TreeNode root,int targetSum,int[] count,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        int sum=0;
        for(int i=path.size()-1;i>=0;i--){
            sum+=path.get(i);
            if(sum==targetSum){
                count[0]++;
            }
        }
        helper(root.left,targetSum,count,path);
        helper(root.right,targetSum,count,path);
        path.remove(path.size()-1);
    }
}