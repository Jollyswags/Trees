/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
     HashMap<Integer,Node> map = new HashMap<>();
    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }
    
    private void dfs(Node root, int level){
        if(root == null) return;
        root.next = map.getOrDefault(level, null);
        map.put(level, root);
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}