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
   int[] minMaxHL= new int[2];//left subtree and right subtree width 
    List<List<Integer>> ans= new ArrayList<>();//resultant list of list of integer 
    
    class pairH//stores the node and their horizontal level 
    {
        TreeNode Node;
        int hl;
        pairH(){}
        pairH(TreeNode Node, int hl)//parameterised constructor to initialize node and its horizontal level
        {
            this.Node= Node;
            this.hl= hl;
        }
    }
    public void width(TreeNode root, int hl)//calculating the horizontal width of the tree 
    {//DFS(postorder)
        if(root == null)//base case when we reach the null node
            return;

        minMaxHL[0]= Math.min(hl, minMaxHL[0]);//left horizontal subtree height (-ve)
        minMaxHL[1]= Math.max(hl, minMaxHL[1]);//right horizontal subtree height (+ve)
        
        width(root.left, hl - 1);//recursing left subtree 
        width(root.right, hl + 1);//recursing right subtree 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        width(root, 0);//0 is the current horizontal level of root node 
        int width= minMaxHL[1] - minMaxHL[0] + 1;//calculating the horizontal width or the number of horizontzl partition //+1 beacuse we are including both upper and lower limit 
        
        for(int i= 0; i < width; i++)//creating new ArrayList of Integer for every horizontal partition in List 
            ans.add(new ArrayList<Integer>());

        PriorityQueue<pairH> parentQ= new PriorityQueue<>((a, b)->{ //Min Priority Queue(min Heap)
            return a.Node.val - b.Node.val;//Comparator customize ordering //ascending sort Node value //if Case-1) a > b then +ve (right of root) Case-2) a < b then -ve (left of root)
        });
        PriorityQueue<pairH> childQ= new PriorityQueue<>((a, b)->{  //Min Priority Queue(min Heap) default
            return a.Node.val - b.Node.val;//Comparator customize ordering  //ascending sort Node value
        });
        
        parentQ.offer(new pairH(root, Math.abs(minMaxHL[0])));//enqueuing the root node 
            
        while(!parentQ.isEmpty())
        {//BFS 
            int size= parentQ.size();//parent pair dequeing condition 
        
            while(size-- > 0)
            {
               pairH temp= parentQ.poll();//minimum valued node of that level will be popped first 
                
               TreeNode Node= temp.Node;
               int hl= temp.hl;
                
               ans.get(hl).add(Node.val);//adding in level sorted order 
                
               if(Node.left != null)
                  childQ.offer(new pairH(Node.left, hl - 1));//adding the right children to the child queue     
			   if(Node.right != null)
			      childQ.offer(new pairH(Node.right, hl + 1));//adding the left children to the child queue 
            } 
            //swapping the reference of Queue when parent queue is Empty
            PriorityQueue<pairH> temp= parentQ;
            parentQ= childQ;
            childQ= temp;
        }
        return ans;//returning the List of List of Integer 
    }
}