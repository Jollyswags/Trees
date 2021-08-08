class Solution {
       public List<Boolean> checkIfPrerequisite(int n, int[][] pr, int[][] queries) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] p : pr) {
            graph.get(p[0]).add(p[1]);
        }
        
        List<Boolean> result = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();
        
        for(int[] q : queries) {
            boolean res = dfs(graph, q[0], q[1], memo);
            result.add(res);
        }
        
        return result;
    }
    
    private boolean dfs(List<List<Integer>> graph, int src, int target, Map<String, Boolean> memo) {
        
        if(memo.containsKey(src + "-" + target)) {
            return memo.get(src + "-" + target);
        }
        
        for(int adj : graph.get(src)) {
            if(adj == target) {
                return true;
            }
            boolean res = dfs(graph, adj, target, memo);
            
            if(res) {
                memo.put(src + "-" + target, true);
                return true;
            }
        }
        
        memo.put(src + "-" + target, false);
        return false;
    }
}