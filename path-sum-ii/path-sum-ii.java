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
       public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> wrap = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        preorder(root, targetSum, stack, wrap);
        return wrap;
    }
    
    private void preorder(TreeNode x, int target, Stack<Integer> stack, List<List<Integer>> wrap) {
        if (x == null)
            return;
        
        stack.push(x.val);
        int sum = target - x.val;

        if (x.left == null && x.right == null && sum == 0) {
            LinkedList<Integer> list = new LinkedList<>(stack);
            wrap.add(list);
        }
        
        preorder(x.left, sum, stack, wrap);
        preorder(x.right, sum, stack, wrap);
        stack.pop();   
    }
}