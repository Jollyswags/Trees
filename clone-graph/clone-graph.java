/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
         if(node==null)                               
      return null;
        
      Queue<Node>q=new LinkedList<>();  
      Map<Node,Node> map=new HashMap<>();
      q.add(node);
        
      map.put(node,new Node(node.val)) ;
        while(!q.isEmpty())
        {
          Node h=  q.poll();
            
            for(Node curr :h.neighbors)
            {
                if(!map.containsKey(curr))
                {
                    map.put(curr,new Node(curr.val));
                    q.add(curr);
                }
                map.get(h).neighbors.add(map.get(curr));
            }
        }
        return map.get(node);
    }
}