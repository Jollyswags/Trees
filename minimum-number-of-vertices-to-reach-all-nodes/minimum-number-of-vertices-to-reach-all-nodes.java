class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean visited[]=new boolean[n];
        List<Integer> l=new ArrayList();
        int i;
        for(i=0;i<edges.size();i++)
        {
            visited[edges.get(i).get(1)]=true;
        }
        for(i=0;i<visited.length;i++)
            if(!visited[i])
                l.add(i);
        return l;
    }
    
}