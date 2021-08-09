class Solution {
     public boolean isCycle(int currVertex, List<Integer>[] edges, boolean[] visited, boolean[] recStack){
        
        if(recStack[currVertex])
            return true;
        
        if(visited[currVertex])
            return false;
        
        visited[currVertex] = true;
        recStack[currVertex] = true;
        
        List<Integer> adj = edges[currVertex];
        
        for(int i=0; i<adj.size(); i++){
            if(isCycle(adj.get(i), edges, visited, recStack)){
                return true;
            }
        }
        recStack[currVertex] = false;
        
        return false;
        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        List<Integer>[] edges = new List[numCourses];
        for (int i=0; i<numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] p : prerequisites) {
            edges[p[1]].add(p[0]);
        }
        
        Boolean res = false;
        for(int i=0; i<numCourses; i++){
            res = isCycle(i, edges, visited, recStack);
            if(res == true){
                return false;
            }
        }
        return true;
    }
}