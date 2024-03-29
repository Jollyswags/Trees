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
class FindElements {

    TreeNode root;
    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        this.root = root;
        set = new HashSet<>();
        recover(root, 0);
    }

    private void recover(TreeNode root, int x) {
        if (root != null) {
            root.val = x;
            set.add(x);
            recover(root.left, 2 * x + 1);
            recover(root.right, 2 * x + 2);
        }
    }


    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */