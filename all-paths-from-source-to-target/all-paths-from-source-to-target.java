class Solution {
    List<List<Integer>> paths;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths=new ArrayList<>();
        helper(graph,0,paths,new ArrayList<>(), graph.length-1);
        return paths;
        
    }
    public void helper(int graph[][],int curr,List<List<Integer>> paths, List<Integer> path, int tar)
    {
        path.add(curr);
        if(curr==tar)
        {
            paths.add(path);
            return;
        }
        for(int i: graph[curr])
        {
            helper(graph,i,paths,new ArrayList<Integer>(path), tar);
            
        }
            
    }
}