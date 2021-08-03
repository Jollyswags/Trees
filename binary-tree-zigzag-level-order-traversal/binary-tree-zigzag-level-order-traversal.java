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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	zigzigTraversal(root, 0, res);
	return res;
}

private void zigzigTraversal(TreeNode node, int level, List<List<Integer>> res) {
	if (node != null) {
		if (level == res.size()) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(node.val);             // Adding node to empty LinkedList is constant
			res.add(list);                  // Appending to ArrayList is constant
		} else {
			LinkedList<Integer> list = (LinkedList) res.get(level);
			if (level % 2 == 0) {            
				list.addLast(node.val);     // Adding last to LinkedList is constant(Tail Pointer)
			} else {
				list.addFirst(node.val);    // Adding first to LinkedList is constant(Head Pointer)
			}
		}
		zigzigTraversal(node.left, level + 1, res);
		zigzigTraversal(node.right, level + 1, res);
	}    
}
}