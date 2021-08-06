class Solution {
   public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(graph, 0, paths, new ArrayList<>(), graph.length - 1);
        return paths;
    }
    
    void helper(int[][]graph, int currentNode, List<List<Integer>> paths, List<Integer> path, int target) {
        path.add(currentNode);
        if (currentNode == target) {
            paths.add(path);
            return;
        }
        for(int i : graph[currentNode]) {
            helper(graph,i, paths, new ArrayList<Integer>(path), target);
        }
    }
}