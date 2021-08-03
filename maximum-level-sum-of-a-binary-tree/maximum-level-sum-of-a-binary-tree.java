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
   
  public int maxLevelSum(TreeNode root) {
        
      Map<Integer, Integer> sumValueOfLevel=new HashMap<>();
      levelParsing(root,sumValueOfLevel,1);

        return Collections.max(sumValueOfLevel.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();

    }
    
    public void levelParsing(TreeNode root, Map<Integer, Integer> sumValueOfLevel, int level){
        if(root==null){
            return;
        }
        
        sumValueOfLevel.put(level, sumValueOfLevel.getOrDefault(level,0)+root.val);
        
        levelParsing(root.right,sumValueOfLevel,level+1);
        levelParsing(root.left,sumValueOfLevel,level+1);
        
    }
}