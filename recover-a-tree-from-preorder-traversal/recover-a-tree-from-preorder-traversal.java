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
   int pos;
	public TreeNode recoverFromPreorder(String traversal) {
		pos = 0;
		return helper(traversal.toCharArray(), 0);
	}

	public TreeNode helper(char[] c, int len){
		if(pos >= c.length) return null;
		TreeNode temp;
		if(isvalid(c, len))
			 temp = new TreeNode(getdata(c, len));
		else
			return null;
		temp.left = helper(c, len + 1); // increase the depth by one for the child nodes.
		temp.right = helper(c, len + 1);
		return temp;
	}

	public int getdata(char[] c, int len){  // returns the data for the current node in the depth 
		int i = pos + len;

		int data = 0;

		while(i < c.length && c[i] != '-')
			data = data * 10 + (c[i++] - '0');
		pos = i;
		return data;    
	}
	public boolean isvalid(char[] c, int len){  // checks whether the data belongs to the current depth ( len )
		int count = 0;

		for(int i = pos; i < c.length && c[i] == '-'; i++)
			count++;

		return count == len;    
	}
}